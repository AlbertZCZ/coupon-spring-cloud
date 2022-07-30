package org.study.coupon.calculation.api.beans;


import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @program: coupon-spring-cloud
 * @description: 订单试算结果，可以看出哪个优惠券力度大
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:08
 **/
@Data
@NoArgsConstructor
public class SimulationResponse {

  // 最省钱的coupon
  private Long bestCouponId;

  // 每一个coupon对应的order价格
  private Map<Long, Long> couponToOrderPrice = Maps.newHashMap();
  
}
