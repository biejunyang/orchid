# Docker介绍
Docker是一个开源的容器引擎，使用Docker可以更快的打包，测试和部署应用程序，缩短从代码编写到部署运行的周期。

Docker开发实现使用的是Google公司的Go语言，对操作系统进程进行了封装隔离，属于操作系统层面的虚拟化技术。隔离的进程也称之为容器，独立于宿主机，以及其他的容器。
### 相关网站：
Docker官网：https://www.docker.com/

Docker官方文档：https://docs.docker.com/

DockerHub：https://www.docker.com/products/docker-hub

Docker从入门倒到实战书籍：https://yeasy.gitbooks.io/docker_practice/



# [Docker架构](https://docs.docker.com/engine/docker-overview/)
* **DOCKER_HOST(宿主机)**：安装了Docker的物理机（也可以是虚拟机）。

* **Docker Daemon(Docker守护进程)**：运行在宿主机上的集成，用来与Docker客户端进行，执行Docker命令。

* **Docker Client**：Docker的用户界面，调用Docker命令的程序或工具

* **Image(Docker镜像)**：Docker程序文件，相当于一个root文件系统，包含了完整的一套程序运行所需要的文件.

* **Container(容器)**：镜像运行时的实体，一个独立于其他容器，和宿主机的进程。镜像是静态的相当于程序文件，容器则运行时状态的程序。（相当于程序和进程的关系）

* **Docker Registry(镜像注册中心)**：一个集中存储和发布镜像的中心，和Maven仓库一样集中管理依赖一样，可以在Docker Registry镜像注册中心发布和下载镜像。一个Docker Registry可以包含多个Docker仓库，每个仓库对应某一种镜像，一个Docker仓库可以包含多个标签，每个标签对应具体的某一个镜像。通过(仓库:标签)既可以具体到Docker Registry中的某个Docker镜像。Docker Registry可以分化公有Docker Registry和私有Docker Registry。最常用的公有Docker Registry就是官方的Dock er Hub，也是Docker下载镜像是默认的Docker Registry。


# Docker快速开始
## Docker安装：https://yeasy.gitbooks.io/docker_practice/install/

## 镜像加速器配置：https://yeasy.gitbooks.io/docker_practice/install/mirror.html

## Docke镜像操作：https://yeasy.gitbooks.io/docker_practice/image/

## Docker Container容器操作：https://yeasy.gitbooks.io/docker_practice/container/

## Dockerfile构建Docker镜像：https://yeasy.gitbooks.io/docker_practice/image/build.html


# Docker部署微服务应用：
## 1、创建Dockerfile构建脚本，如：
    FROM java8
    VOLUME /tmp
    ADD organization-0.0.1-SNAPSHOT.jar app.jar
    ENTRYPOINT ["java","-jar","/app.jar"]


