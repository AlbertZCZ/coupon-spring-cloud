# 服务于用户的子模块
* 实现了用户领券、用户优惠券查找和订单结算功能

## 配置中心
* 引入spring-cloud-starter-alibaba-nacos-config
  * nacos配置管理功能
* 引入spring-cloud-starter-bootstrap
  * bootstrap.yml文件的加载优先级是高于application.yml的，保证在其它组件初始化之前从Nacos读到所有配置项，之后再将获取到的配置项用于后续的初始化流程。
* 添加本地nacos config配置项bootstrap.yml
* CouponCustomerController中disableCoupon从配置中心读取并设置默认值false，可以实现业务逻辑根据配置中心动态修改