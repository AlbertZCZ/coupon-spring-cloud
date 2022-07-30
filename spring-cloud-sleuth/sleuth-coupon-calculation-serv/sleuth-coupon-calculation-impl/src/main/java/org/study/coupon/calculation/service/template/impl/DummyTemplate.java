package org.study.coupon.calculation.service.template.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.study.coupon.calculation.api.beans.ShoppingCart;
import org.study.coupon.calculation.service.template.AbstractRuleTemplate;
import org.study.coupon.calculation.service.template.RuleTemplate;

/**
 * @program: coupon-spring-cloud
 * @description: 空实现
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:25
 **/
@Slf4j
@Component
public class DummyTemplate extends AbstractRuleTemplate implements RuleTemplate {

  @Override
  public ShoppingCart calculate(ShoppingCart order) {
    // 获取订单总价
    long orderTotalAmount = getTotalPrice(order.getProducts());

    order.setCost(orderTotalAmount);
    return order;
  }


  @Override
  protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
    return orderTotalAmount;
  }
  
}
