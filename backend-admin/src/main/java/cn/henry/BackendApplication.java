package cn.henry;

import com.cxytiandi.encrypt.springboot.annotation.EnableEncrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * ε―ε¨η¨εΊ
 *
 * @author Henry
 * @date 2022/2/11 14:40
 */
@Slf4j
@EnableEncrypt
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BackendApplication {
    public static void main(String[] args) {
        System.setProperty("druid.mysql.usePingMethod", "false");
        SpringApplication.run(BackendApplication.class, args);
        log.info("\nππππππ Health Station Backend service started... :)");
    }
}
