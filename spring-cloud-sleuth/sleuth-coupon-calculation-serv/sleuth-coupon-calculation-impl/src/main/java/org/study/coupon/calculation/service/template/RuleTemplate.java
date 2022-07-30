package org.study.coupon.calculation.service.template;

import org.study.coupon.calculation.api.beans.ShoppingCart;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:17
 **/
public interface RuleTemplate {

  // 计算优惠券
  ShoppingCart calculate(ShoppingCart settlement);
}
