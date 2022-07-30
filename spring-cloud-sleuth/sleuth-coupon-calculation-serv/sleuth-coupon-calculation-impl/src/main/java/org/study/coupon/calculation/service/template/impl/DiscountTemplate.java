package org.study.coupon.calculation.service.template.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.study.coupon.calculation.service.template.AbstractRuleTemplate;
import org.study.coupon.calculation.service.template.RuleTemplate;

/**
 * @program: coupon-spring-cloud
 * @description: 打折优惠券
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:25
 **/
@Slf4j
@Component
public class DiscountTemplate extends AbstractRuleTemplate implements RuleTemplate {

  @Override
  protected Long calculateNewPrice(Long totalAmount, Long shopAmount, Long quota) {
    // 计算使用优惠券之后的价格
    Long newPrice = convertToDecimal(shopAmount * (quota.doubleValue()/100));
    log.debug("original price={}, new price={}", totalAmount, newPrice);
    return newPrice;
  }
  
}
