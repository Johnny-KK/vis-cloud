#FROM openjdk:8-jdk-alpine
FROM java:8

# 作者
LABEL MAINTAINER="johnny-kk <1249864985@qq.com>"

# 临时文件目录
VOLUME /tmp

# 将jar包添加到容器中并更名为app.jar

## 方式1
#ADD pm-cloud-sys-0.0.1-SNAPSHOT.jar app.jar

## 方式2
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar

# 运行jar包
RUN bash -c 'touch /app.jar'

# -Djava.security.egd=file:/dev/./urandom 用来指定tomcat启动时安全随机数使用的熵池
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]