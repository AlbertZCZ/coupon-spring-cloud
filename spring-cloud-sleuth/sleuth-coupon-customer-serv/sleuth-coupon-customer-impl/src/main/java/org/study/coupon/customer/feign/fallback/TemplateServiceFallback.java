package org.study.coupon.customer.feign.fallback;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;
import org.study.coupon.customer.feign.TemplateService;
import org.study.coupon.template.api.beans.CouponTemplateInfo;

/**
 * @program: coupon-spring-cloud
 * @description: 服务降级逻辑
 * @author: zhangchaozhen
 * @create: 2022-06-25 16:01
 **/
@Slf4j
@Component
public class TemplateServiceFallback implements TemplateService {

  @Override
  public CouponTemplateInfo getTemplate(Long id) {
    log.info("fallback getTemplate!!!");
    return null;
  }

  @Override
  public Map<Long, CouponTemplateInfo> getTemplateInBatch(Collection<Long> ids) {
    log.info("fallback getTemplateInBatch!!!");
    return Maps.newHashMap();
  }

}
