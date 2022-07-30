package org.study.coupon.customer.feign.fallback;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.study.coupon.customer.feign.TemplateService;
import org.study.coupon.template.api.beans.CouponTemplateInfo;

/**
 * @program: coupon-spring-cloud
 * @description: 可以拿到异常case的降级逻辑
 * @author: zhangchaozhen
 * @create: 2022-06-25 16:11
 **/
@Slf4j
@Component
public class TemplateServiceFallbackFactory implements FallbackFactory<TemplateService> {
    @Override
    public TemplateService create(Throwable throwable) {
        return new TemplateService() {
            @Override
            public CouponTemplateInfo getTemplate(Long id) {
              log.info("fallback factory method test:{}" , throwable.getMessage());
                return null;
            }

          @Override
          public Map<Long, CouponTemplateInfo> getTemplateInBatch(Collection<Long> ids) {
            log.info("fallback factory method test:{}" , throwable.getMessage());
            return Maps.newHashMap();
          }

        };
    }
}
