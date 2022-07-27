package org.study.coupon.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.study.coupon.calculation.api.beans.ShoppingCart;
import org.study.coupon.calculation.api.beans.SimulationOrder;
import org.study.coupon.calculation.api.beans.SimulationResponse;

/**
 * @program: coupon-spring-cloud
 * @description: 计算服务
 * @author: zhangchaozhen
 * @create: 2022-06-24 12:04
 **/
@FeignClient(value = "config-coupon-calculation-serv", path = "/calculator")
public interface CalculationService {

  // 优惠券结算
  @PostMapping("/checkout")
  ShoppingCart checkout(ShoppingCart settlement);

  // 优惠券列表挨个试算
  // 给客户提示每个可用券的优惠额度，帮助挑选
  @PostMapping("/simulate")
  SimulationResponse simulate(SimulationOrder simulator);
  
}
