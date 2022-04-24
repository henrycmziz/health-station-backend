package cn.henry.patient.service;

import cn.henry.common.constant.Constants;
import cn.henry.common.core.domain.AjaxResult;
import cn.henry.common.core.domain.entity.SysUser;
import cn.henry.common.core.domain.model.LoginUser;
import cn.henry.common.core.redis.RedisCache;
import cn.henry.common.exception.ServiceException;
import cn.henry.common.exception.user.UserPasswordNotMatchException;
import cn.henry.common.utils.DateUtils;
import cn.henry.common.utils.MessageUtils;
import cn.henry.common.utils.StringUtils;
import cn.henry.framework.manager.AsyncManager;
import cn.henry.framework.manager.factory.AsyncFactory;
import cn.henry.framework.web.service.PermissionService;
import cn.henry.framework.web.service.SysLoginService;
import cn.henry.framework.web.service.TokenService;
import cn.henry.patient.domain.Patient;
import cn.henry.patient.domain.PatientLoginBody;
import cn.henry.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 患者登录服务接口
 *
 * @author Henry
 * @date 2022-04-07 18:19
 **/
@Slf4j
@Component
public class AppLoginService {
    @Resource
    private TokenService tokenService;

    @Resource
    private SysLoginService sysLoginService;

    @Resource
    private PatientService patientService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private ISysUserService sysUserService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private RedisCache redisCache;

    /**
     * 请求时间戳过期时间5分钟
     */
    private static final int REQUEST_TIME_OUT = 1000 * 60 * 5;

    public String login(PatientLoginBody patientLoginBody) {
        log.debug("login and loginBody:{}", patientLoginBody);

        // 用户验证
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(patientLoginBody.getUsername(), patientLoginBody.getPassword()));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(patientLoginBody.getUsername(), Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            } else {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(patientLoginBody.getUsername(), Constants.LOGIN_FAIL, e.getMessage()));
                throw new ServiceException(e.getMessage());
            }
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        SysUser user = loginUser.getUser();
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(patientLoginBody.getUsername(), Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        sysLoginService.recordLoginInfo(user.getUserId());

        Patient patient = patientService.selectPatientById(user.getUserId());
        if (patient.getIsActive() == 0) {
            patient.setIsActive((byte) 1);
            patient.setActiveTime(DateUtils.getNowDate());
            patientService.updatePatientExpand(patient);
        }

        return tokenService.createToken(loginUser);
    }

    /**
     * 发送注册验证码
     *
     * @param patientLoginBody 患者登录对象
     * @return AjaxResult
     */
    public AjaxResult sendCode(PatientLoginBody patientLoginBody) {
        if (Objects.isNull(patientLoginBody)) {
            return AjaxResult.error(-6, "参数为空");
        }
        // 验证验证码
        if (StringUtils.isBlank(patientLoginBody.getPhoneNo())) {
            return AjaxResult.error(-6, "发送手机号不能为空");
        }
        String validCodeType = "2";
        if (StringUtils.isNotBlank(patientLoginBody.getValidCodeType())) {
            validCodeType = patientLoginBody.getValidCodeType();
        }
        try {
            //SysSmsSend sysSmsSend = sysSmsSendService.sendMessage(loginBody.getPhoneNo(),validCodeType,true);
            //String resultFlag = sysSmsSend.getResultFlag();
            String resultFlag = "n";
            if (resultFlag.equals("f")) {
                return AjaxResult.error(-6, "对不起手机号【" + patientLoginBody.getPhoneNo() + "】发送短信失败：失败原因:");
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        AjaxResult ajax = AjaxResult.success("验证码发送成功");
        return ajax;
    }
}
