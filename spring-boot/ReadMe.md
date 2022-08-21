# Sring Boot超级单体应用SOA架构
spring-web + spring-data-jpa  
**coupon-template-serv**： 创建、查找、克隆、删除优惠券模板  
**coupon-calculation-serv**：计算优惠后的订单价格、试算每个优惠券的优惠幅度        
**coupon-customer-serv**：通过调用template和calculation服务，实现用户领取优惠券、模拟计算最优惠的券、删除优惠券、下订单等操作  
**middleware**：存放一些与业务无关的平台类组件
## 优惠券模板服务coupon-template-serv
**coupon-template-api**：存放公共POJO类或者对外接口的子模块  
**coupon-template-dao**：存放数据库实体类和Dao层的子模块  
**coupon-template-impl**：核心业务逻辑的实现层，对外提供REST API  

## 优惠券计算服务coupon-calculation-serv
**coupon-calculation-api**：存放公共POJO类或者对外接口的子模块  
**coupon-calculation-impl**：核心业务逻辑的实现层，对外提供REST API  
因为calculation服务并不需要访问数据库，所以没有DAO模块。

## 用户服务coupon-customer-serv