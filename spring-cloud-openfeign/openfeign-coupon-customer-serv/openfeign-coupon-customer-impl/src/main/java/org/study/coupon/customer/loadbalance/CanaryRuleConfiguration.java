package org.study.coupon.customer.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @program: coupon-spring-cloud
 * @description: 配置负载均衡策略 注意这里不要写上@Configuration注解
 * @author: zhangchaozhen
 * @create: 2022-06-19 21:19
 **/
public class CanaryRuleConfiguration {

  @Bean
  public ReactorLoadBalancer<ServiceInstance> reactorServiceInstanceLoadBalancer(
      Environment environment,
      LoadBalancerClientFactory loadBalancerClientFactory) {
    String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
    return new CanaryRule(loadBalancerClientFactory.getLazyProvider(name,
        ServiceInstanceListSupplier.class), name);
  }
  
}
