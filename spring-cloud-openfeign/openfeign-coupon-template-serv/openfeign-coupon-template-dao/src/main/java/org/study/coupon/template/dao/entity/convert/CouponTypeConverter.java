package org.study.coupon.template.dao.entity.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.study.coupon.template.api.beans.enums.CouponType;

/**
 * @program: coupon-spring-cloud
 * @description: 优惠券转换器
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:33
 **/

@Converter
public class CouponTypeConverter implements AttributeConverter<CouponType, String>{
  @Override
  public String convertToDatabaseColumn(CouponType couponCategory) {
    return couponCategory.getCode();
  }

  @Override
  public CouponType convertToEntityAttribute(String code) {
    return CouponType.convert(code);
  }

}
