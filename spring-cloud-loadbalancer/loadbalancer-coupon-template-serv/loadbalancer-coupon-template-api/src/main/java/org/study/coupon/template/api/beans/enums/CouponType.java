package org.study.coupon.template.api.beans.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.stream.Stream;
/**
 * @program: coupon-spring-cloud
 * @description: 优惠券类型
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:23
 **/

@Getter
@AllArgsConstructor
public enum CouponType {

  UNKNOWN("unknown", "0"),
  MONEY_OFF("满减券", "1"),
  DISCOUNT("打折", "2"),
  RANDOM_DISCOUNT("随机减", "3"),
  LONELY_NIGHT_MONEY_OFF("寂寞午夜double券", "4"),
  ANTI_PUA("PUA加倍奉还券", "5");

  private final String description;

  // 存在数据库里的最终code
  private final String code;

  public static CouponType convert(String code) {
    return Stream.of(values())
        .filter(couponType -> couponType.code.equalsIgnoreCase(code))
        .findFirst()
        .orElse(UNKNOWN);
  }
  
}
