package org.study.template.controller;

import com.alibaba.fastjson.JSON;
import java.util.Collection;
import java.util.Map;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.coupon.template.api.beans.CouponTemplateInfo;
import org.study.coupon.template.api.beans.PagedCouponTemplateInfo;
import org.study.coupon.template.api.beans.TemplateSearchParams;
import org.study.template.service.intf.CouponTemplateService;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 22:50
 **/
@Slf4j
@RestController
@RequestMapping("/template")
@AllArgsConstructor
public class CouponTemplateController {

  private final CouponTemplateService couponTemplateService;

  // 创建优惠券
  @PostMapping("/addTemplate")
  public CouponTemplateInfo addTemplate(@Valid @RequestBody CouponTemplateInfo request) {
    log.info("Create coupon template: data={}", request);
    return couponTemplateService.createTemplate(request);
  }

  @PostMapping("/cloneTemplate")
  public CouponTemplateInfo cloneTemplate(@RequestParam("id") Long templateId) {
    log.info("Clone coupon template: data={}", templateId);
    return couponTemplateService.cloneTemplate(templateId);
  }

  // 读取优惠券
  @GetMapping("/getTemplate")
  public CouponTemplateInfo getTemplate(@RequestParam("id") Long id){
    log.info("Load template, id={}", id);
    return couponTemplateService.loadTemplateInfo(id);
  }

  // 批量获取
  @GetMapping("/getBatch")
  public Map<Long, CouponTemplateInfo> getTemplateInBatch(@RequestParam("ids") Collection<Long> ids) {
    log.info("getTemplateInBatch: {}", JSON.toJSONString(ids));
    return couponTemplateService.getTemplateInfoMap(ids);
  }

  // 搜索模板
  @PostMapping("/search")
  public PagedCouponTemplateInfo search(@Valid @RequestBody TemplateSearchParams request) {
    log.info("search templates, payload={}", request);
    return couponTemplateService.search(request);
  }

  // 优惠券无效化
  @DeleteMapping("/deleteTemplate")
  public void deleteTemplate(@RequestParam("id") Long id){
    log.info("Load template, id={}", id);
    couponTemplateService.deleteTemplate(id);
  }
}
