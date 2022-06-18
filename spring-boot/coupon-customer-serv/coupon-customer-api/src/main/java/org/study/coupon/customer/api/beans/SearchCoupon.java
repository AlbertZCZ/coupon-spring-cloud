package org.study.coupon.customer.api.beans;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: coupon-spring-cloud
 * @description: 查询条件
 * @author: zhangchaozhen
 * @create: 2022-06-18 21:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCoupon {

  @NotNull
  private Long userId;
  private Long shopId;
  private Integer couponStatus;
}
