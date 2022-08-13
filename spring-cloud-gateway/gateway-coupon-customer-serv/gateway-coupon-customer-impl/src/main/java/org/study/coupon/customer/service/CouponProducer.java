package org.study.coupon.customer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.study.coupon.customer.api.beans.RequestCoupon;

/**
 * 类<code>Doc</code>用于：stream生产者
 *
 * @author zhang
 * @date 2022-08-13
 */
@Service
@Slf4j
@AllArgsConstructor
public class CouponProducer {

    private final StreamBridge streamBridge;

    public void send(RequestCoupon requestCoupon) {
        log.info("send message to coupon-producer: {}", requestCoupon);
        streamBridge.send("addCoupon-out-0", requestCoupon);
    }

    public void delete(Long userId,Long couponId) {
        log.info("send message to coupon-producer: {}", userId);
        streamBridge.send("deleteCoupon-out-0", userId + "," + couponId);
    }

}
