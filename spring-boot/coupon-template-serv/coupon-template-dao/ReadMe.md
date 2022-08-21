# 主要负责和数据库的对接、读取
## 依赖
**coupon-template-api**: 引入api包下的公共类  
**spring-boot-starter-data-jpa**: 添加spring-data-jpa的功能进行CRUD操作  
**mysql-connector-java**: 引入mysql驱动包，驱动版本尽量与mysql版本保持一致
## 数据库实体对象的Java类：CouponTemplate
运用了javax.persistence包和Spring JPA包的标准注解，对数据库字段进行了映射
## CouponTemplateDao
jpa使用了一种约定大于配置的思想,只需要把要查询的字段定义在接口的方法名中,发起调用时后台就会自动转化成可执行的SQL语句  
### 构造方法名的过程需要遵循<起手式>By<查询字段><连接词>的结构
* 起手式：以find开头表示查询，以count开头表示计数；
* 查询字段：字段名要保持和Entity类中定义的字段名称一致；
* 连接词：每个字段之间可以用And、Or、Before、After等一些列丰富的连词串成一个查询语句。
### 对于复杂查询，我们可以使用自定义SQL、或者Example对象查找的方式。
makeCouponUnavailable方法,将SQL语句定义在了Query注解中  
Example查询的方式,构造一个对象，将想要查询的字段填入其中，做成查询模板，调用Dao层的findAll方法即可  
