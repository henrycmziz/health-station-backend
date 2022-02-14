package cn.henry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author Henry
 * @date 2022/2/11 14:40
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BackendApplication {
    public static void main(String[] args) {
        System.setProperty("druid.mysql.usePingMethod", "false");
        SpringApplication.run(BackendApplication.class, args);
        log.info("😎😎😎😎😎😎 Health Station Backend service started... :)");
    }
}
