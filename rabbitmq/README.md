# RabbitMQ 消息队列案例
由浅入深的讲解的RabbitMQ 在Java应用中的案例。
# 博客地址
https://blog.csdn.net/a767815662
# 微信公共号：华星详谈
欢迎大家给与一定的支持，在公众号中作者会持续分享Java相关的技术以及面试、资料等。

# RabbitAdmin类与RabbitTemplate类方法讲解
## RabbitAdmin（该类封装了对 RabbitMQ 的管理操作）
//创建四种类型的 Exchange，均为持久化，不自动删除
rabbitAdmin.declareExchange(new DirectExchange("direct.exchange",true,false));
rabbitAdmin.declareExchange(new TopicExchange("topic.exchange",true,false));
rabbitAdmin.declareExchange(new FanoutExchange("fanout.exchange",true,false));
rabbitAdmin.declareExchange(new HeadersExchange("header.exchange",true,false));
//删除 Exchange
rabbitAdmin.deleteExchange("header.exchange");
