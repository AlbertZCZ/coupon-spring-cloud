package org.study.coupon.customer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.study.coupon.customer.api.beans.RequestCoupon;
import org.study.coupon.customer.service.intf.CouponCustomerService;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 类<code>Doc</code>用于：stream消费者
 *
 * @author zhang
 * @date 2022-08-13
 */
@Service
@Slf4j
@AllArgsConstructor
public class CouponConsumer {

    private final CouponCustomerService couponCustomerService;

    @Bean
    public Consumer<RequestCoupon> addCoupon() {
        return requestCoupon -> {
            log.info("receive message from coupon-producer: {}", requestCoupon);
            couponCustomerService.requestCoupon(requestCoupon);
        };
    }

    @Bean
    public Consumer<String> deleteCoupon() {
        return requestCoupon -> {
            log.info("receive message from coupon-producer: {}", requestCoupon);
            List<Long> collect = Arrays.stream(requestCoupon.split(",")).map(Long::valueOf).collect(Collectors.toList());
            couponCustomerService.deleteCoupon(collect.get(0),collect.get(1));
        };
    }

}
