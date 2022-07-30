package org.study.coupon.calculation.service.intf;

import org.springframework.web.bind.annotation.RequestBody;
import org.study.coupon.calculation.api.beans.ShoppingCart;
import org.study.coupon.calculation.api.beans.SimulationOrder;
import org.study.coupon.calculation.api.beans.SimulationResponse;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:13
 **/
public interface CouponCalculationService {

  ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart);

  SimulationResponse simulateOrder(@RequestBody SimulationOrder cart);
}
