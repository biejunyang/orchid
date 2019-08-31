# orchid
应用开发中技术栈整理，共享，交流，学习。不限于开发语言，开发技术，开发方向。应用开发中需要某些技术点时，可以快速从项目中获取到相应的代码实现，甚至可以通过代码生成器快速生成集合了所需技术点的舒适化项目框架，可以进行快速二次开发。
基于SpringCloud的微服务开发脚手架，整合了spring-security-oauth2、springboot-admin、feign、hystrix、spring-cloud-gateway、turbine等，让项目开发快速进入业务开发，而不需过多时间花费在架构搭建上。








## 技术点整理
| 目录 | 介绍 | 文档 | 示例 |
| -- |-- |-- |-- |
| Docker | Docker使用 | [介绍](Docker/README.md) | [Demo示例](orchild-examples/docker-example) |





## 项目目录结构

```
orchid
├── orchid-dependencies         --第三方依赖库管理
├── orchid-common               --通用工具包项
│   ├── orchild-common-core         --核心包
│   ├── orchild-common-web          --web工具包
│   ├── orchild-common-cloud        --spring cloud工具包 
├── orchid-cloud-app            --云服务管理中心
│   ├── orchild-eureka              --eureka注册中心 
│   ├── orchild-gateway             --gateway网关
│   |    ├──orchild-gateway-web          --基于springcloud gateway的网关网关
│   |    ├──orchild-gateway-admin        --springcloud gateway的网关管理模块
│   ├── orchild-monitor             --监控中心 
│   |    ├──orchild-service-admin        --基于springboot admin服务管理中心
│   |    ├──orchild-hystrix-dashboard    --shystrix监控
│   |    ├──orchild-turbine              --turbine监控聚集 
├── orchid-service-app          --业务服务中心     
├── orchid-examples             --技术学习Demo
├── docs                 --文档及资源文件
├── data                 --server及服务数据存储目录
│   ├── elasticsearch      --elasticsearch配置数据存储位置
│   ├── postgres           --postgres数据库文件存储目录 
│   ├── rabbitmq           --rabbitmq数据文件存储目录
│   └── redis              --redis数据文件存储目录
├── readme.md            --readme文档入口
└── pom.xml              --业务服务子项目
```

## module目录结构

```
├── logs                     --日志目录
│   ├── spring.log
│   └── spring.log.2018-04-15.0.gz
├── pom.xml                  --module maven配置文件
├── src                      --源码目录
│   ├── main                   --源文件
│   │   ├── db                 --服务db脚本目录
│   │   │   ├── db.sql           --创建库的脚本
│   │   │   ├── ddl              --建表语句等ddl
│   │   │   │   ├── mysql          --mysql ddl
│   │   │   │   └── postgres       --postgres ddl
│   │   │   └── dml              --基础数据dml
│   │   ├── docker             --docker相关配置文件
│   │   │   └── Dockerfile       --dockerfile
│   │   ├── docs               --接口文档目录，一般由swagger生成
│   │   ├── java               --java源码目录
│   │   │   ├── dao              --数据操作层
│   │   │   ├── service          --业务逻辑层
│   │   │   ├── provider         --调用第三方服务的提供类
│   │   │   ├── rest             --接口controller
│   │   │   ├── entity           --实体类
│   │   │   │   ├── form           --rest表单校验
│   │   │   │   ├── param          --dao参数，可以由form转化来
│   │   │   │   ├── po             --实体类
│   │   │   │   └── vo             --视图对象
│   │   │   ├── events           --事件或消息处理类
│   │   │   ├── config           --配置类
│   │   │   ├── exception        --异常处理相关类
│   │   │   ├── interceptor      --拦截器相关类
│   │   │   └── task             --定时任务
│   │   └── resources          --配置文件目录 
│   │       ├── application.yml  --springboot的应用配置文件
│   │       └── bootstrap.yml    --springboot的配置文件
│   └── test                   --测试目录
│       ├── java                 --java测试案例目录
│       └── resources          --配置文件目录 
│          └── application.yml   --springboot test的配置文件
└── target                     --编译目标目录
```
## 开发规范

[规范文档](docs/pattern.md)


[Spring Cloud架构](https://www.processon.com/view/link/597ffa52e4b06a973c4d86ba)
