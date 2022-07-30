package org.study.coupon.customer.service;

import org.study.coupon.template.api.beans.CouponInfo;
import org.study.entiry.Coupon;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:05
 **/
public class CouponConverter {

  public static CouponInfo convertToCoupon(Coupon coupon) {

    return CouponInfo.builder()
        .id(coupon.getId())
        .status(coupon.getStatus().getCode())
        .templateId(coupon.getTemplateId())
        .shopId(coupon.getShopId())
        .userId(coupon.getUserId())
        .template(coupon.getTemplateInfo())
        .build();
  }
}
