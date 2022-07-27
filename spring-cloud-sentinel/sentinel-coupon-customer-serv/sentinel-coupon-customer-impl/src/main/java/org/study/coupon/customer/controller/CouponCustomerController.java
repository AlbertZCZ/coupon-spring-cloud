package org.study.coupon.customer.controller;

import java.util.List;
import javax.validation.Valid;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.coupon.calculation.api.beans.ShoppingCart;
import org.study.coupon.calculation.api.beans.SimulationOrder;
import org.study.coupon.calculation.api.beans.SimulationResponse;
import org.study.coupon.customer.api.beans.RequestCoupon;
import org.study.coupon.customer.api.beans.SearchCoupon;
import org.study.coupon.customer.service.intf.CouponCustomerService;
import org.study.coupon.template.api.beans.CouponInfo;
import org.study.entiry.Coupon;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-19 10:03
 **/

@Slf4j
//动态同步nacos config中属性
@RefreshScope
@RestController
@RequestMapping("coupon-customer")
@RequiredArgsConstructor
public class CouponCustomerController {

  @Value("${disableCouponRequest:false}")
  private Boolean disableCoupon;
  private final CouponCustomerService customerService;

  @PostMapping("requestCoupon")
  @SentinelResource(value = "requestCoupon", fallback = "getNothing")
  public org.study.entiry.Coupon requestCoupon(@Valid @RequestBody RequestCoupon request) {
    if (Boolean.TRUE.equals(disableCoupon)) {
      log.warn("disableCoupon is true, skip requestCoupon");
      return new Coupon();
    }
    return customerService.requestCoupon(request);
  }

  // 用户删除优惠券
  @DeleteMapping("deleteCoupon")
  public void deleteCoupon(@RequestParam("userId") Long userId,
      @RequestParam("couponId") Long couponId) {
    customerService.deleteCoupon(userId, couponId);
  }

  // 用户模拟计算每个优惠券的优惠价格
  @PostMapping("simulateOrder")
  public SimulationResponse simulate(@Valid @RequestBody SimulationOrder order) {
    return customerService.simulateOrderPrice(order);
  }

  // ResponseEntity - 指定返回状态码 - 可以作为一个课后思考题
  @PostMapping("placeOrder")
  // 可以使用同一个资源，这样控制就会对两个资源生效
  @SentinelResource(value = "checkout")
  public ShoppingCart checkout(@Valid @RequestBody ShoppingCart info) {
    return customerService.placeOrder(info);
  }


  // 实现的时候最好封装一个search object类
  @PostMapping("findCoupon")
  @SentinelResource(value = "customer-findCoupon")
  public List<CouponInfo> findCoupon(@Valid @RequestBody SearchCoupon request) {
    return customerService.findCoupon(request);
  }
}
