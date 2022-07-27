package org.study.coupon.calculation.service.template.impl;

import java.util.Calendar;
import org.springframework.stereotype.Component;
import org.study.coupon.calculation.service.template.AbstractRuleTemplate;
import org.study.coupon.calculation.service.template.RuleTemplate;

/**
 * @program: coupon-spring-cloud
 * @description: 优惠券翻倍
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:27
 **/
@Component
public class LonelyNightTemplate extends AbstractRuleTemplate implements RuleTemplate {

  @Override
  protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
    Calendar calendar = Calendar.getInstance();
    int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

    if (hourOfDay >= 23 || hourOfDay < 2) {
      quota *= 2;
    }

    Long benefitAmount = shopTotalAmount < quota ? shopTotalAmount : quota;
    return orderTotalAmount - benefitAmount;
  }
}
