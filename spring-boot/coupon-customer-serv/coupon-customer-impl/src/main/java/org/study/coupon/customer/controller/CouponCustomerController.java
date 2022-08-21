package org.study.coupon.customer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.study.coupon.calculation.api.beans.ShoppingCart;
import org.study.coupon.calculation.api.beans.SimulationOrder;
import org.study.coupon.calculation.api.beans.SimulationResponse;
import org.study.coupon.customer.api.beans.RequestCoupon;
import org.study.coupon.customer.api.beans.SearchCoupon;
import org.study.coupon.customer.dao.entiry.Coupon;
import org.study.coupon.customer.service.intf.CouponCustomerService;
import org.study.coupon.template.api.beans.CouponInfo;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-19 10:03
 **/

@Slf4j
@RestController
@RequestMapping("coupon-customer")
@AllArgsConstructor
public class CouponCustomerController {

  private final CouponCustomerService customerService;

  @PostMapping("requestCoupon")
  public Coupon requestCoupon(@Valid @RequestBody RequestCoupon request) {
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
  public ShoppingCart checkout(@Valid @RequestBody ShoppingCart info) {
    return customerService.placeOrder(info);
  }


  @PostMapping("findCoupon")
  public List<CouponInfo> findCoupon(@Valid @RequestBody SearchCoupon request) {
    return customerService.findCoupon(request);
  }
}
