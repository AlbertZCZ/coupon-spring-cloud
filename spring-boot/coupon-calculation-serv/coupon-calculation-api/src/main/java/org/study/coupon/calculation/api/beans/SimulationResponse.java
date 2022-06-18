package org.study.coupon.calculation.api.beans;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:08
 **/
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class SimulationResponse {

  // 最省钱的coupon
  private Long bestCouponId;

  // 每一个coupon对应的order价格
  private Map<Long, Long> couponToOrderPrice = Maps.newHashMap();
  
}
