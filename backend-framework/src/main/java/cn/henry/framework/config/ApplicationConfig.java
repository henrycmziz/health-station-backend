package cn.henry.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.TimeZone;

/**
 * 程序注解配置
 * 注解 2： 表示通过aop框架暴露该代理对象,AopContext能够访问
 * 注解 3： 指定要扫描的Mapper类的包的路径
 *
 * @author ruoyi
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("cn.henry.**.mapper")
public class ApplicationConfig {
    /**
     * 时区配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }
}
