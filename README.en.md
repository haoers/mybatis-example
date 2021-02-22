# mybatis-example

#### Description
mybatis-example 实践服务示例

#### Software Architecture
spring-boot(alibaba-cloud) 分层

#### Installation

1.  mysql server(127.0.0.1:3306)
2.  mysql db name (mybatis-example)
3.  mysql username=root  password=123456
4.  执行sql:   test-server/test-datasource/init-sql/schema.sql

#### Instructions

1.  run主类: test-server/test-service/*.TestApplication.java
2.  浏览器访问：  http://127.0.0.1:9101/user/info?id=1

#### consult doc

1.  generator-utils:   自动化构建mapper、entity、mapper.xml
2.  自动化生成main.class: generator-utils/test/java/*.MyBatisGenerator.java
3.  @ICondition:  自定义参数绑定


#### Gitee Feature

1.  git@github.com:haoers/mybatis-example.git