package cn.henry.patient.controller;

import cn.henry.common.constant.Constants;
import cn.henry.common.core.domain.AjaxResult;
import cn.henry.common.utils.SecurityUtils;
import cn.henry.framework.web.service.SysPermissionService;
import cn.henry.patient.domain.Patient;
import cn.henry.patient.domain.PatientLoginBody;
import cn.henry.patient.service.AppLoginService;
import cn.henry.patient.service.PatientService;
import com.cxytiandi.encrypt.springboot.annotation.Decrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 患者登录控制器
 *
 * @author Henry
 * @date 2022-04-07 18:04
 **/
@RestController
@RequestMapping("/patient")
public class AppLoginController {
    @Resource
    private AppLoginService appLoginService;

    @Resource
    private SysPermissionService permissionService;

    @Resource
    private PatientService patientService;

    /**
     * 小程序患者登录
     *
     * @return token
     */
    @Decrypt
    @PostMapping("/login")
    public AjaxResult loginByPassword(@RequestBody @Validated PatientLoginBody patientLoginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = appLoginService.login(patientLoginBody);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        Patient user = patientService.selectPatientById(SecurityUtils.getLoginUser().getUser().getUserId());
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    ///**
    // * 发送验证码
    // */
    //@PostMapping("/sendCode")
    //@ResponseBody
    //public AjaxResult sendRegisterCode(HttpServletRequest request) {
    //    String phoneNo = request.getParameter("phoneNo");
    //    String validCodeType = request.getParameter("validCodeType");
    //    // 登录结果
    //    PatientLoginBody loginParams = PatientLoginBody.builder().validCodeType(validCodeType).phoneNo(phoneNo).build();
    //    return loginService.sendCode(loginParams);
    //}
}
