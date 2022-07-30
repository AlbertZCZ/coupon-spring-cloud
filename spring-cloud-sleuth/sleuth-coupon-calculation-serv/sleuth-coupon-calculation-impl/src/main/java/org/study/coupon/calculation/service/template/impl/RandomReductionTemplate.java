package org.study.coupon.calculation.service.template.impl;

import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.study.coupon.calculation.service.template.AbstractRuleTemplate;
import org.study.coupon.calculation.service.template.RuleTemplate;

/**
 * @program: coupon-spring-cloud
 * @description: 随机规则
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:29
 **/
@Slf4j
@Component
public class RandomReductionTemplate extends AbstractRuleTemplate implements RuleTemplate {

  @Override
  protected Long calculateNewPrice(Long totalAmount, Long shopAmount, Long quota) {
    // 计算使用优惠券之后的价格
    long maxBenefit = Math.min(shopAmount, quota);
    int reductionAmount = new Random().nextInt((int) maxBenefit);
    Long newCost = totalAmount - reductionAmount;

    log.debug("original price={}, new price={}", totalAmount, newCost );
    return newCost;
  }
  
}
