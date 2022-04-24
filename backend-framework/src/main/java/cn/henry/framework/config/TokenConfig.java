package cn.henry.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 读取token相关配置
 *
 * @author Henry
 * @date 2022-02-11 20:46
 **/
@Configuration
@ConfigurationProperties(prefix = "token")
public class TokenConfig {
    /**
     * 令牌自定义标识
     */
    private static String header;

    /**
     * 令牌密钥
     */
    private static String secret;

    /**
     * 令牌有效期（默认30分钟）
     */
    private static int expireTime;

    /**
     * app令牌有效期（两天）
     */
    private static int appExpireTime;

    public static String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        TokenConfig.header = header;
    }

    public static String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        TokenConfig.secret = secret;
    }

    public static int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        TokenConfig.expireTime = expireTime;
    }

    public static int getAppExpireTime() {
        return appExpireTime;
    }

    public void setAppExpireTime(int appExpireTime) {
        TokenConfig.appExpireTime = appExpireTime;
    }
}
