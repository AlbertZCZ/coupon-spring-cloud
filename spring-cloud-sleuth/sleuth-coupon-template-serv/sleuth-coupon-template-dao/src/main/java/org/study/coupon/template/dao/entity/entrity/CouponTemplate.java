package org.study.coupon.template.dao.entity.entrity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.study.coupon.template.api.beans.enums.CouponType;
import org.study.coupon.template.api.beans.ruls.TemplateRule;
import org.study.coupon.template.dao.entity.convert.CouponTypeConverter;
import org.study.coupon.template.dao.entity.convert.RuleConverter;

/**
 * @program: coupon-spring-cloud
 * @description: 优惠券模版
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:30
 **/

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon_template")
public class CouponTemplate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  // 状态是否可用
  @Column(name = "available", nullable = false)
  private Boolean available;

  @Column(name = "name", nullable = false)
  private String name;

  // 适用门店-如果为空，则为全店满减券
  @Column(name = "shop_id")
  private Long shopId;

  @Column(name = "description", nullable = false)
  private String description;

  // 优惠券类型
  @Column(name = "type", nullable = false)
  @Convert(converter = CouponTypeConverter.class)
  private CouponType category;

  // 创建时间，通过@CreateDate注解自动填值（需要配合@JpaAuditing注解在启动类上生效）
  @CreatedDate
  @Column(name = "created_time", nullable = false)
  private Date createdTime;

  // 优惠券核算规则，平铺成JSON字段
  @Column(name = "rule", nullable = false)
  @Convert(converter = RuleConverter.class)
  private TemplateRule rule;

}
