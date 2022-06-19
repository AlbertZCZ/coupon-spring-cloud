package org.study.coupon.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.study.coupon.customer.loadbalance.CanaryRuleConfiguration;

/**
 * @program: coupon-spring-cloud
 * @description: 启动类
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:41
 **/

@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
//用于扫描Dao @Repository 引入template包 会包含 @EnableJpaRepositories
@EnableJpaRepositories(basePackages = {"org.study.coupon.customer"})
//用于扫描JPA实体类 @Entity，默认扫本包当下路径
@EntityScan(basePackages = {"org.study"})
@ComponentScan(basePackages = {"org.study"})
//发到loadbalancer-coupon-template-serv调用使用CanaryRuleConfiguration定义的规则
@LoadBalancerClient(value = "loadbalancer-coupon-template-serv", configuration = CanaryRuleConfiguration.class)
public class LoadbalancerCustomerApplication {

  public static void main(String[] args) {
    SpringApplication.run(LoadbalancerCustomerApplication.class, args);
  }
}
