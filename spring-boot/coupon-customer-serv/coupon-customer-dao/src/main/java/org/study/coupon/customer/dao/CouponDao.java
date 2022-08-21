package org.study.coupon.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.coupon.customer.dao.entiry.Coupon;
/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 21:55
 **/
public interface CouponDao extends JpaRepository<Coupon, Long> {

  /**
   * 根据用户ID和Template ID，统计用户从当前优惠券模板中领了多少张券
   * @param userId
   * @param templateId
   * @return
   */
  long countByUserIdAndTemplateId(Long userId, Long templateId);
  
}
