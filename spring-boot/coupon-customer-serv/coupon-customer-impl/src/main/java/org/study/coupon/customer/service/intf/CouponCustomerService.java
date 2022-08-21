package org.study.coupon.customer.service.intf;

import org.study.coupon.calculation.api.beans.ShoppingCart;
import org.study.coupon.calculation.api.beans.SimulationOrder;
import org.study.coupon.calculation.api.beans.SimulationResponse;
import org.study.coupon.customer.api.beans.RequestCoupon;
import org.study.coupon.customer.api.beans.SearchCoupon;
import org.study.coupon.customer.dao.entiry.Coupon;
import org.study.coupon.template.api.beans.CouponInfo;

import java.util.List;

/**
 * @program: coupon-spring-cloud
 * @description: 用户对接服务
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:05
 **/
public interface CouponCustomerService {

  // 领券接口

  /**
   * @description: 领券接口
   * @param request
   * @return
   */
  Coupon requestCoupon(RequestCoupon request);

  // 核销优惠券

  /**
   * @Description: 核销优惠券
   * @param info
   * @return
   */
  ShoppingCart placeOrder(ShoppingCart info);

  // 优惠券金额试算

  /**
   * @Description: 优惠券金额试算
   * @param order
   * @return
   */
  SimulationResponse simulateOrderPrice(SimulationOrder order);

  void deleteCoupon(Long userId, Long couponId);


  /**
   * 查询用户优惠券
   * @param request
   * @return
   */
  List<CouponInfo> findCoupon(SearchCoupon request);
}
