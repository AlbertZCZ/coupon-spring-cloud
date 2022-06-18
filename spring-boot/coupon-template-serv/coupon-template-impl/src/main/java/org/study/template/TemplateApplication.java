package org.study.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @program: coupon-spring-cloud
 * @description: 启动类
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:41
 **/

@SpringBootApplication
@EntityScan("org.study")
@EnableJpaRepositories("org.study")
@ComponentScan(basePackages = {"org.study"})
public class TemplateApplication {

  public static void main(String[] args) {
    SpringApplication.run(TemplateApplication.class, args);
  }
}
