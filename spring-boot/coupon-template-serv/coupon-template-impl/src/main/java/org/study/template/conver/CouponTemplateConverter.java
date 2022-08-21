package org.study.template.conver;

import org.study.coupon.template.api.beans.CouponTemplateInfo;
import org.study.coupon.template.dao.entity.entrity.CouponTemplate;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:43
 **/
public class CouponTemplateConverter {

  /**
   * model转换为dto
   * @param template model
   * @return dto
   */
  public static CouponTemplateInfo convertToTemplateInfo(CouponTemplate template) {

    return CouponTemplateInfo.builder()
        .id(template.getId())
        .name(template.getName())
        .desc(template.getDescription())
        .type(template.getCategory().getCode())
        .shopId(template.getShopId())
        .available(template.getAvailable())
        .rule(template.getRule())
        .build();
  }
}
