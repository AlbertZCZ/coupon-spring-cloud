package org.study.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: coupon-spring-cloud
 * @description: 优惠券模版查询
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:21
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemplateSearchParams {

  private Long id;

  private String name;

  private String type;

  private Long shopId;

  private Boolean available;

  private int page;

  private int pageSize;
}
