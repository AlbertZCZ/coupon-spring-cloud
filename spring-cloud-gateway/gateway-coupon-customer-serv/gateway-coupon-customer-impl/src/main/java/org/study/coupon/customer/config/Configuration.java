package org.study.coupon.customer.config;

import feign.Logger;
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


  /**
   * @description: 
   * NONE：不记录任何信息，这是OpenFeign默认的日志级别；
   * BASIC：只记录服务请求的URL、HTTP Method、响应状态码（如200、404等）和服务调用的执行时间；
   * HEADERS：在BASIC的基础上，还记录了请求和响应中的HTTP Headers；
   * FULL：在HEADERS级别的基础上，还记录了服务请求和服务响应中的Body和metadata，FULL级别记录了最完整的调用信息。
   * @return FULL
   */
  @Bean
  Logger.Level feignLogger() {
    return Logger.Level.FULL;
  }
}
