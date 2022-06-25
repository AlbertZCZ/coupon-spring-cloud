package org.study.coupon.calculation.service.template.impl;

import org.springframework.stereotype.Component;
import org.study.coupon.calculation.service.template.AbstractRuleTemplate;
import org.study.coupon.calculation.service.template.RuleTemplate;

/**
 * @program: coupon-spring-cloud
 * @description: 满减优惠券计算规则
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:28
 **/
@Component
public class MoneyOffTemplate extends AbstractRuleTemplate implements RuleTemplate {

  @Override
  protected Long calculateNewPrice(Long totalAmount, Long shopAmount, Long quota) {
    // benefitAmount是扣减的价格
    // 如果当前门店的商品总价<quota，那么最多只能扣减shopAmount的钱数
    long benefitAmount = shopAmount < quota ? shopAmount : quota;
    return totalAmount - benefitAmount;
  }
  
}
