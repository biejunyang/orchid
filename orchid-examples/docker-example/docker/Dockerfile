#基于哪个镜像
FROM java8

#将宿主机文件夹挂载到当前容器
VOLUME /tmp

#复制jar文件到容器中,目的路径是相对于容器的根路径/
ADD docker-example-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]