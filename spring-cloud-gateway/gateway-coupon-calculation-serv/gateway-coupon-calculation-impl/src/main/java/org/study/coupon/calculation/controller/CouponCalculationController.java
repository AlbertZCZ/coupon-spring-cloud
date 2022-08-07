package org.study.coupon.calculation.controller;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.study.coupon.calculation.api.beans.ShoppingCart;
import org.study.coupon.calculation.api.beans.SimulationOrder;
import org.study.coupon.calculation.api.beans.SimulationResponse;
import org.study.coupon.calculation.service.intf.CouponCalculationService;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-19 10:11
 **/

@Slf4j
@RestController
@RequestMapping("calculator")
@AllArgsConstructor
public class CouponCalculationController {

  private final CouponCalculationService calculationService;

  // 优惠券结算
  @PostMapping("/checkout")
  @ResponseBody
  public ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart settlement) {
    log.info("do calculation: {}", JSON.toJSONString(settlement));
    return calculationService.calculateOrderPrice(settlement);
  }

  // 优惠券列表挨个试算
  // 给客户提示每个可用券的优惠额度，帮助挑选
  @PostMapping("/simulate")
  @ResponseBody
  public SimulationResponse simulate(@RequestBody SimulationOrder simulator) {
    return calculationService.simulateOrder(simulator);
  }
  
}
