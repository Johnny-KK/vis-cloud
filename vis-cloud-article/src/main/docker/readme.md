---
--date: 2020.04.09
--author: xu.wenchang
---

# Docker部署SpringBoot项目

## 方式一

将已经打包好的项目`jar包`和`Dockerfile`放到`docker`环境下，然后用`docker build`命令生成镜像文件

## 方式二

+ 本地有`docker`环境
    - 进入命令行环境
    - 切换到项目的根目录
    - 执行命令`mvn package docker:build`，进行打包和制作镜像，镜像的名称等在`pom`文件的`docker-maven-plugin`中配置
    -
+ 本地没有`docker`环境
    - 将代码环境发送到有docker环境的机器上
    - 执行第一种情况的后续操作




