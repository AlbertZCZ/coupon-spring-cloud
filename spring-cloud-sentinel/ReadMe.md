# 五、集成服务容错Sentinel
选择改造的微服务为模板微服务和用户微服务
1. 搭建sentinel监控台
2. 对应微服务引入依赖
3. 修改配置，直连控制台
4. 使用注解对资源进行标记
## 内部异常治理
## 外部流量控制
### 直连
### 关联
如果两个资源之间有竞争关系，比如说，它们共享同一个数据库连接池，这时候你就可以使用“关联流控”对低优先级的资源进行流控，让高优先级的资源获得竞争优势
### 链路
如果在一个应用中，对同一个资源有多条不同的访问链路，那么我们就可以应用“链路流控”，实现API级别的精细粒度限流
### 实现针对调用源的限流
这个实现过程分为两步。第一步，你要想办法在服务请求中加上一个特殊标记，告诉Template服务是谁调用了你；
第二步，你需要在Sentinel控制台设置流控规则的针对来源。
标记通过对openFeign动手脚OpenfeignSentinelInterceptor