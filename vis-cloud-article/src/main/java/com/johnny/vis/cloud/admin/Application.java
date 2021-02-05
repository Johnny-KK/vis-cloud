package com.johnny.vis.cloud.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Johnny
 * @date 2020-12-21
 */
@MapperScan("com.johnny.vis.cloud.article.dao")
@SpringBootApplication(scanBasePackages={"com.johnny.vis.cloud","com.johnny.vis.cloud.common"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
