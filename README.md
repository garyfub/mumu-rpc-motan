#mumu-rpc-motan
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/babymm/mumu-rpc-motan/blob/master/LICENSE)[![Maven Central](https://img.shields.io/maven-central/v/com.weibo/motan.svg?label=Maven%20Central)](https://mvnrepository.com/search?q=motan)[![Build Status](https://img.shields.io/travis/weibocom/motan/master.svg?label=Build)](https://github.com/babymm/mumu-rpc-motan)[![OpenTracing-1.0 Badge](https://img.shields.io/badge/OpenTracing--1.0-enabled-blue.svg)](http://opentracing.io)
>[mumu-rpc-motan](https://github.com/babymm/mumu-rpc-motan)是一个以[weibo montan](https://github.com/weibocom/motan)为基础的测试程序，了解motan rpc架构设计和编程思想。同时也是想要多了解一些rpc框架，为项目做好rpc技术选型。
- - - - -
#项目简述

- - - - -
#项目架构
mumu-rpc-motan项目一共分为三个模块，接口模板、服务端模块、客户端模块。
1. 接口模块主要定义一些接口，将接口单独抽取出来成为一个模快，主要是为了rpc调用。接口包括普通接口和异步调用接口，异步调用接口也就是在接口上添加@MotanAsync注解，然后在项目的pom中配置build-helper-maven-plugin插件，使用该插件生成异步调用的接口。至于具体的业务逻辑，请查看源码。
2. 服务端模块包含各种方式开启rpc服务。
   1. 极简单模式
   2. consul注册中心
   3. zookeeper模式
   4. 手动模式

#motan架构

#个人观点

** 以上观点纯属个人看法，如有不同，欢迎指正 **
** 联系方式 **
** email:<babymm@aliyun.com> **
** github:[https://github.com/babymm](https://github.com/babymm) **