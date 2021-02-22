# mybatis-example

#### Description
mybatis-example 实践服务示例

#### Software Architecture
spring-boot(alibaba-cloud) 分层

#### 1、git分支说明
master：线上分支（不可随意合并，master是最正确的代码，可随时部署到线上）
dev：测试环境的分支（用于外网测试使用的分支）
其他分支取名规范:
功能开发分支：feature/{功能英文}-{mmdd}.{开发人员英文缩写}
fixbug分支：hotfix/{修复功能英文}-{mmdd}.{开发人员英文缩写}



# 软件架构
### 一、后端服务说明
#### 1、服务model说明
<p>common-utils: 通用工具类</p>
<p>generator-utils: mybatis自动化生成工具-MyGenerator.main()</p>
<p>test-server:  参考test服务,优先启动-TestApplication.main()</p>
---------------------------------业务服务-----------------------------------------


#### 2、工程架构目录说明(服务参考test-server)
<p>test-server</p>
<p>++test-service(业务层)</p>
<p>++test-datasource(数据层)</p>

#### 3、mysql建表说明
<p>表必须符合3范式</p>
<p>表必须拥有字段:主键id自增、del_flg,create_time,update_time</p>
<p>索引谁用谁建(索引名示例:idx_phone_num)</p>

表:user(主表)抽象表
user(主表)抽象表

#### 4、后端接口说明:
<H5>获取用户信息api:[http://127.0.0.1:9101/user/info?id=1]()</H5>


### 二、前端服务说明




#### 参与贡献
haoer



