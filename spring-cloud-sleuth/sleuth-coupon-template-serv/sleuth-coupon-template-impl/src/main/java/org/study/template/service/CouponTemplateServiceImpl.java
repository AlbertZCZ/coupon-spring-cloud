package org.study.template.service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.study.coupon.template.api.beans.CouponTemplateInfo;
import org.study.coupon.template.api.beans.PagedCouponTemplateInfo;
import org.study.coupon.template.api.beans.TemplateSearchParams;
import org.study.coupon.template.api.beans.enums.CouponType;
import org.study.coupon.template.dao.entity.CouponTemplateDao;
import org.study.coupon.template.dao.entity.entrity.CouponTemplate;
import org.study.template.conver.CouponTemplateConverter;
import org.study.template.service.intf.CouponTemplateService;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:47
 **/
@Slf4j
@Service
@AllArgsConstructor
public class CouponTemplateServiceImpl implements CouponTemplateService {

  private final CouponTemplateDao templateDao;

  // 克隆优惠券
  @Override
  public CouponTemplateInfo cloneTemplate(Long templateId) {
    log.info("cloning template id {}", templateId);
    CouponTemplate source = templateDao.findById(templateId)
        .orElseThrow(() -> new IllegalArgumentException("invalid template ID"));

    source.setAvailable(true);
    source.setId(null);
    templateDao.save(source);
    return CouponTemplateConverter.convertToTemplateInfo(source);
  }

  /**
   * 创建优惠券模板
   */
  @Override
  public CouponTemplateInfo createTemplate(CouponTemplateInfo request) {
    // 单个门店最多可以创建100张优惠券模板
    if (request.getShopId() != null) {
      Integer count = templateDao.countByShopIdAndAvailable(request.getShopId(), true);
      if (count >= 100) {
        log.error("the totals of coupon template exceeds maximum number");
        throw new UnsupportedOperationException("exceeded the maximum of coupon templates that you can create");
      }
    }

    // 创建优惠券
    CouponTemplate template = CouponTemplate.builder()
        .name(request.getName())
        .description(request.getDesc())
        .category(CouponType.convert(request.getType()))
        .available(true)
        .shopId(request.getShopId())
        .rule(request.getRule()).createdTime(new Date())
        .build();
    template = templateDao.save(template);

    return CouponTemplateConverter.convertToTemplateInfo(template);
  }

  @Override
  public PagedCouponTemplateInfo search(TemplateSearchParams request) {
    CouponTemplate example = CouponTemplate.builder()
        .shopId(request.getShopId())
        .category(CouponType.convert(request.getType()))
        .available(request.getAvailable())
        .name(request.getName())
        .build();

    Pageable page = PageRequest.of(request.getPage(), request.getPageSize());
    templateDao.findAll(Example.of(example), page);

    Page<CouponTemplate> result = templateDao.findAll(Example.of(example), page);
    List<CouponTemplateInfo> couponTemplateInfos = result.stream()
        .map(CouponTemplateConverter::convertToTemplateInfo)
        .toList();

    return PagedCouponTemplateInfo.builder()
        .templates(couponTemplateInfos)
        .page(request.getPage())
        .total(result.getTotalElements())
        .build();
  }

  public List<CouponTemplateInfo> searchTemplate(CouponTemplateInfo request) {
    CouponTemplate example = CouponTemplate.builder()
        .shopId(request.getShopId())
        .category(CouponType.convert(request.getType()))
        .available(request.getAvailable())
        .name(request.getName())
        .build();
    // 可以用下面的方式做分页查询
//        Pageable page = PageRequest.of(0, 100);
//        templateDao.findAll(Example.of(example), page);
    List<CouponTemplate> result = templateDao.findAll(Example.of(example));
    return result.stream()
        .map(CouponTemplateConverter::convertToTemplateInfo)
        .toList();
  }

  /**
   * 通过ID查询优惠券模板
   */
  @Override
  public CouponTemplateInfo loadTemplateInfo(Long id) {
    Optional<CouponTemplate> template = templateDao.findById(id);
    return template.map(CouponTemplateConverter::convertToTemplateInfo).orElse(null);
  }

  // 将券无效化
  @Override
  @Transactional
  public void deleteTemplate(Long id) {
    int rows = templateDao.makeCouponUnavailable(id);
    if (rows == 0) {
      throw new IllegalArgumentException("Template Not Found: " + id);
    }
  }

  /**
   * 批量读取模板
   */
  @Override
  public Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids) {

    List<CouponTemplate> templates = templateDao.findAllById(ids);

    return templates.stream()
        .map(CouponTemplateConverter::convertToTemplateInfo)
        .collect(Collectors.toMap(CouponTemplateInfo::getId, Function.identity()));
  }
}
