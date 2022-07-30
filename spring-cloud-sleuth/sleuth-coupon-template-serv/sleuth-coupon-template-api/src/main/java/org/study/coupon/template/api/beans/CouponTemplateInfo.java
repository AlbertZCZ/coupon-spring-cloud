package org.study.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import org.study.coupon.template.api.beans.ruls.TemplateRule;

/**
 * @program: coupon-spring-cloud
 * @description: 优惠券模版
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:17
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponTemplateInfo {

  private Long id;

  @NotNull
  private String name;

  // 优惠券描述
  @NotNull
  private String desc;

  // 优惠券类型
  @NotNull
  private String type;

  // 适用门店 - 若无则为全店通用券
  private Long shopId;

  /** 优惠券规则 */
  @NotNull
  private TemplateRule rule;

  private Boolean available;
}
