package org.study.coupon.calculation.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.study.coupon.calculation.api.beans.ShoppingCart;
import org.study.coupon.calculation.api.beans.SimulationOrder;
import org.study.coupon.calculation.api.beans.SimulationResponse;
import org.study.coupon.calculation.service.intf.CouponCalculationService;
import org.study.coupon.calculation.service.template.CouponTemplateFactory;
import org.study.coupon.calculation.service.template.RuleTemplate;
import org.study.coupon.template.api.beans.CouponInfo;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:13
 **/
@Slf4j
@Service
@AllArgsConstructor
public class CouponCalculationServiceImpl implements CouponCalculationService {

  private final CouponTemplateFactory couponProcessorFactory;

  // 优惠券结算
  // 这里通过Factory类决定使用哪个底层Rule，底层规则对上层透明
  @Override
  public ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart) {
    log.info("calculate order price: {}", JSON.toJSONString(cart));
    RuleTemplate ruleTemplate = couponProcessorFactory.getTemplate(cart);
    return ruleTemplate.calculate(cart);
  }


  // 对所有优惠券进行试算，看哪个最赚钱
  @Override
  public SimulationResponse simulateOrder(@RequestBody SimulationOrder order) {
    SimulationResponse response = new SimulationResponse();
    long minOrderPrice = Long.MAX_VALUE;

    // 计算每一个优惠券的订单价格
    for (CouponInfo coupon : order.getCouponInfos()) {
      ShoppingCart cart = new ShoppingCart();
      cart.setProducts(order.getProducts());
      cart.setCouponInfos(Lists.newArrayList(coupon));
      cart = couponProcessorFactory.getTemplate(cart).calculate(cart);

      Long couponId = coupon.getId();
      long orderPrice = cart.getCost();

      // 设置当前优惠券对应的订单价格
      response.getCouponToOrderPrice().put(couponId, orderPrice);

      // 比较订单价格，设置当前最优优惠券的ID
      if (minOrderPrice > orderPrice) {
        response.setBestCouponId(coupon.getId());
        minOrderPrice = orderPrice;
      }
    }
    return response;
  }
}
