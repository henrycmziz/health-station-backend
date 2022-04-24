package cn.henry.patient.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 患者登录对象
 *
 * @author henry
 */
@Data
public class PatientLoginBody {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不可空哈")
    private String username;

    /**
     * 用户密码
     */
    @NotBlank(message = "密码不可空哈")
    private String password;

    /**
     * 手机号
     */
    private String phoneNo;

    /**
     * 验证码
     */
    private String code;

    /**
     * session中的验证码
     */
    private String codeInSession;

    /**
     * 验证码类型1注册验证码2普通登录验证码
     */
    private String validCodeType;

    /**
     * 登录方式0验证码登录，1用户名密码登录，2本机一键登录，3微信单点登录
     */
    private Byte loginType;
}
