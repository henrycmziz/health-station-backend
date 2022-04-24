package cn.henry.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum UserType {
    /**
     * 系统用户
     */
    SYS("00"),

    /**
     * 小程序患者用户
     */
    PATIENT("11");

    private final String code;

    UserType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
