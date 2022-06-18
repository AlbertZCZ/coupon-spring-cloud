package org.study.coupon.calculation.api.beans;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.study.coupon.template.api.beans.CouponInfo;

/**
 * @program: coupon-spring-cloud
 * @description: 购物车
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

  @NotEmpty
  private List<Product> products;

  private Long couponId;

  private long cost;

  // 目前只支持单张优惠券
  // 但是为了以后的扩展考虑，你可以添加多个优惠券的计算逻辑
  private List<CouponInfo> couponInfos;

  @NotNull
  private Long userId;
}
