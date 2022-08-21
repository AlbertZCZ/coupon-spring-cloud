package org.study.coupon.customer.dao.entiry;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.study.coupon.customer.dao.convert.CouponStatusConverter;
import org.study.coupon.customer.api.enums.CouponStatus;
import org.study.coupon.template.api.beans.CouponTemplateInfo;

/**
 * @program: coupon-spring-cloud
 * @description:
 * @author: zhangchaozhen
 * @create: 2022-06-18 21:55
 **/
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon")
public class Coupon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  // 对应的模板ID - 不使用one to one映射
  // 不推荐使用级联查询的原因是为了防止滥用而导致的DB性能问题
  @Column(name = "template_id", nullable = false)
  private Long templateId;

  // 所有者的用户ID
  @Column(name = "user_id", nullable = false)
  private Long userId;

  // 冗余一个shop id方便查找
  @Column(name = "shop_id")
  private Long shopId;

  // 优惠券的使用/未使用状态
  @Column(name = "status", nullable = false)
  @Convert(converter = CouponStatusConverter.class)
  private CouponStatus status;

  // 被Transient标记的属性是不会被持久化的
  @Transient
  private CouponTemplateInfo templateInfo;

  // 获取时间自动生成
  @CreatedDate
  @Column(name = "created_time", nullable = false)
  private Date createdTime;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Coupon coupon = (Coupon) o;
    return id != null && Objects.equals(id, coupon.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
