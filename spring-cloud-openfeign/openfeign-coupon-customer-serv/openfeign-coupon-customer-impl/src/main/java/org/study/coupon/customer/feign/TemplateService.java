package org.study.coupon.customer.feign;

import java.util.Collection;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.study.coupon.template.api.beans.CouponTemplateInfo;

/**
 * @program: coupon-spring-cloud
 * @description: 模版接口
 * @author: zhangchaozhen
 * @create: 2022-06-24 12:02
 **/

@FeignClient(value = "coupon-template-serv", path = "/template"
//        fallback = TemplateServiceFallback.class,
//    fallbackFactory = TemplateServiceFallbackFactory.class
)
public interface TemplateService {

  // 读取优惠券
  @GetMapping("/getTemplate")
  CouponTemplateInfo getTemplate(@RequestParam("id") Long id);

  // 批量获取
  @GetMapping("/getBatch")
  Map<Long, CouponTemplateInfo> getTemplateInBatch(@RequestParam("ids") Collection<Long> ids);
  
}
