package org.study.coupon.template.api.beans.ruls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: coupon-spring-cloud
 * @description: 券模板的计算规则
 * @author: zhangchaozhen
 * @create: 2022-06-18 19:19
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

  // 满减 - 减掉的钱数
  // 折扣 - 90 = 9折,  95=95折
  private Long quota;
  //对于境内电商行业来说，金额往往是以分为单位的
  // 最低达到多少消费才能用
  private Long threshold;
}
