package org.study.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: coupon-spring-cloud
 * @description: 优惠券信息
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:16
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponInfo {

  private Long id;

  private Long templateId;

  private Long userId;

  private Long shopId;

  private Integer status;

  private CouponTemplateInfo template;
}
