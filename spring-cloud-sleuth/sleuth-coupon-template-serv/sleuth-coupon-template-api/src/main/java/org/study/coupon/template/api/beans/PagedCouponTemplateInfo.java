package org.study.coupon.template.api.beans;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @program: coupon-spring-cloud
 * @description: 创建优惠券模版
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:20
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedCouponTemplateInfo {

  public List<CouponTemplateInfo> templates;

  public int page;

  public long total;
}
