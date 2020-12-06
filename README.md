# HuaXing-SpringCloudDemo
以SpringCloud 微服务框架为基础，集成了目前市面上各种技术。
## 版本信息
1：SpringBoot  版本：2.2.11.RELEASE

2：SpringCloud 版本：Hoxton.SR9

3：Java        版本：Java8
## 博客地址
https://blog.csdn.net/a767815662
## 微信公共号：华星详谈
欢迎大家给与一定的支持，在公众号中作者会持续分享Java相关的技术以及面试、资料等。

##项目结构介绍​
    --- com.huaxing.rabbitmq
        | --- _01hello                  原生态API（hello 模式）
        | --- _02_work                  原生态API（work 模式）
        | --- _03publish_subscribe      原生态API（publish_subscribe 模式）
        | --- _04routing                原生态API（routing 模式）
        | --- _05topics                 原生态API（topics 模式） 
        | --- _06springboot             集成SpringBoot
             | --- RecvToSpringBoot             接收者服务
             | --- SendToSpringBootController   发送者服务