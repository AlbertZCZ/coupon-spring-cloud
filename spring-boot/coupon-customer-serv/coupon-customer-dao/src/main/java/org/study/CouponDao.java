package org.study;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.entiry.Coupon;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 21:55
 **/
public interface CouponDao extends JpaRepository<Coupon, Long> {

  long countByUserIdAndTemplateId(Long userId, Long templateId);
  
}
