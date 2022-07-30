# 六、集成链路追踪 Sleuth
1. POM依赖
2. 采样配置
> 通过TracingFeignClient类，将一些列Tag标记塞进OpenFeign构造的服务请求的Header中
## 使用Zipkin收集并查看链路数据
* 使用RocketMQ作为中转站
* 使用Zipkin收集数据
* Stream是Spring Cloud中专门用来对接消息中间件的组件
## 通过ELK组件搭建日志检索系统
* 添加logstash-logback-encoder依赖项
* 配置logback输出源