package org.study.coupon.customer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @program: coupon-spring-cloud
 * @description: 类中定义的Bean方法会被AnnotationConfigApplicationContext和AnnotationConfigWebApplicationContext扫描并初始化
 * @author: zhangchaozhen
 * @create: 2022-06-19 20:13
 **/
@org.springframework.context.annotation.Configuration
public class Configuration {

  @Bean
  // 1.ReactorLoadBalancerClientAutoConfiguration 
  // 2.LoadBalancerBeanPostProcessorAutoConfiguration LoadBalanced实现
  @LoadBalanced
  public WebClient.Builder register() {
    return WebClient.builder();
  }
  
}
