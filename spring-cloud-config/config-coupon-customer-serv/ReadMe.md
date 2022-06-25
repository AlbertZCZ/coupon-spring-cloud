# 服务于用户的子模块
* 实现了用户领券、用户优惠券查找和订单结算功能

## 配置中心
* 引入spring-cloud-starter-alibaba-nacos-config
  * nacos配置管理功能
* 引入spring-cloud-starter-bootstrap
  * bootstrap.yml文件的加载优先级是高于application.yml的
* 添加本地nacos config配置项bootstrap.yml