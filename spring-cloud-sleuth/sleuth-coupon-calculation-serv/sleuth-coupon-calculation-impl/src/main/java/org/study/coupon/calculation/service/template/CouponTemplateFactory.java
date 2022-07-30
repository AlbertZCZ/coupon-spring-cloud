package org.study.coupon.calculation.service.template;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.study.coupon.calculation.api.beans.ShoppingCart;
import org.study.coupon.calculation.service.template.impl.AntiPauTemplate;
import org.study.coupon.calculation.service.template.impl.DiscountTemplate;
import org.study.coupon.calculation.service.template.impl.DummyTemplate;
import org.study.coupon.calculation.service.template.impl.LonelyNightTemplate;
import org.study.coupon.calculation.service.template.impl.MoneyOffTemplate;
import org.study.coupon.calculation.service.template.impl.RandomReductionTemplate;
import org.study.coupon.template.api.beans.CouponTemplateInfo;
import org.study.coupon.template.api.beans.enums.CouponType;

/**
 * @program: coupon-spring-cloud
 * @description: 工厂方法根据订单中的优惠券信息，返回对应的Template用于计算优惠价
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:17
 **/
@Component
@Slf4j
@AllArgsConstructor
public class CouponTemplateFactory {

  private final MoneyOffTemplate moneyOffTemplate;

  private final DiscountTemplate discountTemplate;

  private final RandomReductionTemplate randomReductionTemplate;

  private final LonelyNightTemplate lonelyNightTemplate;

  private final DummyTemplate dummyTemplate;
  private final AntiPauTemplate antiPauTemplate;

  public RuleTemplate getTemplate(ShoppingCart order) {
    // 不使用优惠券
    if (CollectionUtils.isEmpty(order.getCouponInfos())) {
      // dummy模板直接返回原价，不进行优惠计算
      return dummyTemplate;
    }

    // 获取优惠券的类别
    // 目前每个订单只支持单张优惠券
    CouponTemplateInfo template = order.getCouponInfos().get(0).getTemplate();
    CouponType category = CouponType.convert(template.getType());

    return switch (category) {
      // 订单满减券
      case MONEY_OFF -> moneyOffTemplate;
      // 随机立减券
      case RANDOM_DISCOUNT -> randomReductionTemplate;
      // 午夜下单优惠翻倍
      case LONELY_NIGHT_MONEY_OFF -> lonelyNightTemplate;
      // 打折券
      case DISCOUNT -> discountTemplate;
      case ANTI_PUA -> antiPauTemplate;
      // 未知类型的券模板
      default -> dummyTemplate;
    };
  }
  
}
