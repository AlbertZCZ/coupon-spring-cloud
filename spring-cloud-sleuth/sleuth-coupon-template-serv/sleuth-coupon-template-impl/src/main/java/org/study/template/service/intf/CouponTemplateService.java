package org.study.template.service.intf;

import java.util.Map;
import java.util.Collection;
import org.study.coupon.template.api.beans.CouponTemplateInfo;
import org.study.coupon.template.api.beans.PagedCouponTemplateInfo;
import org.study.coupon.template.api.beans.TemplateSearchParams;

/**
 * @program: coupon-spring-cloud
 * @description: 查询模版
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:45
 **/
public interface CouponTemplateService {

  // 创建优惠券模板
  CouponTemplateInfo createTemplate(CouponTemplateInfo request);

  CouponTemplateInfo cloneTemplate(Long templateId);

  // 模板查询（分页）
  PagedCouponTemplateInfo search(TemplateSearchParams request);

  // 通过模板ID查询优惠券模板
  CouponTemplateInfo loadTemplateInfo(Long id);

  // 让优惠券模板无效
  void deleteTemplate(Long id);

  // 批量查询
  // Map是模板ID，key是模板详情
  Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids);
  
}
