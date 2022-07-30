package org.study.coupon.template.dao.entity.convert;

import com.alibaba.fastjson.JSON;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.study.coupon.template.api.beans.ruls.TemplateRule;

/**
 * @program: coupon-spring-cloud
 * @description: 规则转换器
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:34
 **/
@Converter
public class RuleConverter implements AttributeConverter<TemplateRule, String> {

  @Override
  public String convertToDatabaseColumn(TemplateRule rule) {
    return JSON.toJSONString(rule);
  }

  @Override
  public TemplateRule convertToEntityAttribute(String rule) {
    return JSON.parseObject(rule, TemplateRule.class);
  }
}
