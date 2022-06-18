package org.study.coupon.customer.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @program: coupon-spring-cloud
 * @description: 用户领券
 * @author: zhangchaozhen
 * @create: 2022-06-18 21:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCoupon {

  // 用户领券
  @NotNull
  private Long userId;

  // 券模板ID
  @NotNull
  private Long couponTemplateId;
}
