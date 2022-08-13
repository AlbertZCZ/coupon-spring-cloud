# 七、集成网关 Gateway
> 不要把gateway作为直接对外的网关层，只用于内部服务治理，对外还是交给nginx这类高性能网关做。

![img.png](images/gateway.png)

gateway本身也是一个注册在nacos上的微服务，这就意味着它可以获取到nacos中所有服务的注册表，这样就可以根据本地的路由规则，将请求精准无误地送达到每个微服务组件中。
## 路由规则
![img.png](images/ruter.png)
### 路由
gateway的基本单元，每个路由都有一个目标地址，这个地址就是当前路由规则要调用的目标服务
### 谓词
实际是路由判断规则，比如，可以为某个路由设置一条谓词规则，约定访问路径的匹配规则为Path=/bingo/*，这种情况下只有以/bingo/开头的路径才会被当前路由选中。
当某个请求匹配到多个路由，有优先级设置。
### 过滤器
gateway把请求转发给目标服务的过程中，把这个任务全权委托给了过滤器（Filter）来处理。

![img.png](images/filter.png)

## 集成gateway

### 跨域配置
定义在的spring.cloud.gateway.globalcors.cors-configurations节点

![img.png](images/img.png "相关配置说明")

### 定义路由规则
RoutesConfiguration
## Redis + Lua实现限流方案
RedisLimitationConfig
### 使用nacos添加动态路由表
但凡有动态配置相关的需求，使用Nacos Config就对了
定义一个底层的网关路由规则编辑类，它的作用是将变化后的路由信息添加到网关上下文中GatewayService
定义一个DynamicRoutesLoader的类，它实现了InitializingBean接口，在afterPropertiesSet方法中执行了两项任务，
第一项任务是调用Nacos提供的NacosConfigManager类加载指定的路由配置文件，配置文件名是routes-config.json；
第二项任务是将前面我们定义的DynamicRoutesListener注册到routes-config.json文件的监听列表中，这样一来，每次这个文件发生变动，监听器都能够获取到通知。

# 八、集成Stream实现消息驱动
## 添加生产者CouponProducer
## 添加消费者CouponConsumer
要确保消费者方法的名称和配置文件中所定义的Function Name以及Binding Name保持一致
todo: Stream绑定RocketMQ