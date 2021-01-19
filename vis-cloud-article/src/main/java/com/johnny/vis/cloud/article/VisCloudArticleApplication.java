package com.johnny.vis.cloud.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Johnny
 */
@SpringBootApplication
@MapperScan("com.johnny.vis.cloud.article.dao")
public class VisCloudArticleApplication {
	public static void main(String[] args) {
		SpringApplication.run(VisCloudArticleApplication.class, args);
	}
}
