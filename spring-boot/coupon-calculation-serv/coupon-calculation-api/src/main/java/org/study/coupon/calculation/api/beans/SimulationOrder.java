package org.study.coupon.calculation.api.beans;

/**
 * @program: coupon-spring-cloud
 * @description: 最优惠
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:07
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import org.study.coupon.template.api.beans.CouponInfo;

// 试算最优的优惠券
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationOrder {

  @NotEmpty
  private List<Product> products;

  @NotEmpty
  private List<Long> couponIDs;

  private List<CouponInfo> couponInfos;

  @NotNull
  private Long userId;
  
}
