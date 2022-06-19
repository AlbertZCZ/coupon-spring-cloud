package org.study.coupon.template.api.beans.ruls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @program: coupon-spring-cloud
 * @description: 优惠券计算规则
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:18
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRule {

  /** 可以享受的折扣 */
  private Discount discount;

  // 每个人最多可以领券数量
  private Integer limitation;

  // 过期时间
  private Long deadline;
}
