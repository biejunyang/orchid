#基于哪个镜像
FROM java8

#将宿主机文件夹挂载到当前容器
VOLUME /tmp

#复制jar文件到容器中,源路径是相当于构建上下文路径，目的路径可以是容器的绝对路径，也可以相对于容器的工作目录(WORKDIR指令设置),默认是/根路径
ADD docker-example-0.0.1-SNAPSHOT.jar app.jar

#声明容器需要暴露的端口，主要是告知镜像使用者
EXPOSE 8080

#配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/app.jar"]