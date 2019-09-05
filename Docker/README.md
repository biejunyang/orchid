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

* **Docker Daemon(Docker守护进程)**：运行在宿主机上的集成，用来与Docker客户端进行交互，执行Docker命令。

* **Docker Client**：Docker的用户界面，调用Docker命令的程序或工具

* **Image(Docker镜像)**：Docker程序文件，相当于一个root文件系统，包含了完整的一套程序运行所需要的文件.

* **Container(容器)**：镜像运行时的实体，一个独立于其他容器，和宿主机的进程。镜像是静态的相当于程序文件，容器则运行时状态的程序。（相当于程序和进程的关系）

* **Docker Registry(镜像注册中心)**：一个集中存储和发布镜像的中心，和Maven仓库一样集中管理依赖一样，可以在Docker Registry镜像注册中心发布和下载镜像。一个Docker Registry可以包含多个Docker仓库，每个仓库对应某一种镜像，一个Docker仓库可以包含多个标签，每个标签对应具体的某一个镜像。通过(仓库:标签)既可以具体到Docker Registry中的某个Docker镜像。Docker Registry可以分化公有Docker Registry和私有Docker Registry。最常用的公有Docker Registry就是官方的Dock er Hub，也是Docker下载镜像是默认的Docker Registry。


# Docker快速开始
### Docker安装：https://yeasy.gitbooks.io/docker_practice/install/

### 镜像加速器配置：https://yeasy.gitbooks.io/docker_practice/install/mirror.html
   Docker国内镜像库：https://registry.docker-cn.com
   
   DaoCloud镜像库：http://f1361db2.m.daocloud.io
   
   网易镜像库：http://hub-mirror.c.163.com
   
   阿里云镜像库：登录阿里云控制台查看
   
   
### Docker镜像操作：https://yeasy.gitbooks.io/docker_practice/image/
   docker search image ：镜像查找
   
   docker pull image：镜像下载
   
   docker rmi image：删除本地镜像
   
   
### Docker Container容器操作：https://yeasy.gitbooks.io/docker_practice/container/
   docker run：运行镜像成容器
   
   docker rm :删除容器
   
   docker start：运行容器
   
   docker stop：停止容器运行
   
   docker restart:重启容器


### Dockerfile构建Docker镜像：https://yeasy.gitbooks.io/docker_practice/image/build.html
   docker build -t iamgeName 构建上下文路径

### Docker 镜像发布到Registry注：https://yeasy.gitbooks.io/docker_practice/repository/
   发布镜像：docker push username/docker-example:1.0.1-SNAPSHOT
   
   
   Registry登录退出：docker login,docker logout
   
   
   注意：发布镜像时需要登录授权，默认上传到的是DockerHub注册服务器中的个人仓库下，所以发布镜像格式为：username/镜像名:标记；username为个人账户名，表示个人仓库

   发布私有Registry，镜像完整地址如：docker push registry-url[:port]/repostiry/name:tag



# Docker部署微服务应用：
### 1、创建Dockerfile构建脚本，如：
    #基于哪个镜像
    FROM java8
      
    #将宿主机文件夹挂载到当前容器
    VOLUME /tmp
    
    #复制jar文件到容器中,源路径是相当于构建上下文路径，目的路径是相对于容器的工作目录,默认是/根路径
    ADD docker-example-0.0.1-SNAPSHOT.jar app.jar
    
    #声明容器需要暴露的端口，主要是告知镜像使用者
    EXPOSE 8080
    
    #配置容器启动后执行的命令
    ENTRYPOINT ["java","-jar","/app.jar"]
    
### 2、执行Docker Build命令将jar文件构建成Docker镜像，如：
    docker build -t orchid-examples/docker-example:1.0.1-SNAPSHOT .
   -t：指定镜像仓库名及标签
   
   . ：指定镜像构建上下文路径,.表示当前目录，
   
   **注意**：Docker构建镜像是在docker引擎中进行的，而不是在本地宿主机中，宿主机只是在通过docker客户端(cmd)与Docker引擎（Docker Deamon）进行交互，通知Docker引擎进行构建镜像工作。但是构建中需要的文件时在本地宿主机中，所以需要提前将构建需要的文件上传到Docker引擎中，于是引入了构建上下文的概念。
   构建时Docker build命令会获取到这个构建上线文路径，会将该路径下的所有内容打包上传到Docker引擎，Docker引擎获取到构建上线文包后，就可以获取到构建需要的文件，开始构建
   
### 3、执行Docker run命令运行镜像，生成Docker容器
    docker run -d -p 8080:8080 orchid-examples/docker-example



# Docker Maven插件构建Docker镜像：
  一般不手动使用Docker build命令执行Dockerfile脚本构建镜像。通常使用Maven Docker插件使用maven命令来构建Docker镜像。常用的Maven Docker插件：
   插件名：docker-maven-plugin
   官方地址：https://github.com/spotify/docker-maven-plugin
    
## 1、docker-maven插件构建镜像有两种方式：一种是将构建信息都定义在pom.xml文件中，不需要Dock erfile脚本，pom中支持的构建指令包括，FROM,ADD,CMD等构建指令；第二种是pom.xml文件中指定Dockerfile脚本位置，传入构建参数进行构建：
### 1.1、pom.xml文件中指定构建信息，如：
    <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>docker-maven-plugin</artifactId>
        <version>1.2.0</version>
        <configuration>
            <!--构建的镜像名-->
            <imageName>${project.artifactId}</imageName>
            <imageTags>
                <imageTag>${project.version}</imageTag>
            </imageTags>
            <!--强制覆盖镜像的某个标记-->
            <forceTags>true</forceTags>
    
            <!--基础镜像-->
            <baseImage>fabletang/jre8-alpine</baseImage>
            <!--声明要暴露的端口 -->
            <exposes>8080</exposes>
            <!--文件复制指令，复制文件到容器指定目录-->
            <resources>
                <resource>
                    <!--容器目标路径-->
                    <targetPath>/</targetPath>
                    <directory>${project.build.directory}</directory>
                    <include>${project.build.finalName}.jar</include>
                </resource>
            </resources>
            <!--容器启动后执行的命令-->
            <entryPoint>["java", "-jar", "${project.build.finalName}.jar"]</entryPoint>
        </configuration>
    </plugin>
 
 
 ### 1.2、pom.xml文件读取Dockerfile文件构建
 使用Dockerfile文件时，pom文件中必须指定‘DockerDirectory’元素指定Dockerfile文件目录，pom文件中定义的baseImage,maintainer,cmd,entryPoint等元素的值江北忽略，Dockerfile文件中的为准，‘resources’元素仍然有效，但是只是将文件复制上构建目录中，并没有直接复制到Docker引擎中 ,pom文件如：

     <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>docker-maven-plugin</artifactId>
        <version>1.2.0</version>
        <configuration>
            <!--构建的镜像名-->
            <imageName>${project.artifactId}</imageName>
            <imageTags>
                <imageTag>${project.version}</imageTag>
            </imageTags>
    
            <!--强制覆盖镜像的某个标记-->
            <forceTags>true</forceTags>
    
            <!-- 指定Dockerfile 路径-->
            <dockerDirectory>${basedir}/docker</dockerDirectory>
    
            <!--Docker构建时的目录,默认是${project.build.directory}，构建上下文目录则是该目录下的docker目录-->
            <buildDirectory>${project.build.directory}</buildDirectory>
            <!--构建参数设置-->
            <buildArgs>
                <JAR_FILE>${project.build.finalName}.jar</JAR_FILE>
            </buildArgs>
    
    
            <!--文件复制指令，复制文件到构建目录-->
            <resources>
                <resource>
                    <!--容器目标路径-->
                    <targetPath>/</targetPath>
                    <directory>${project.build.directory}</directory>
                    <include>${project.build.finalName}.jar</include>
                </resource>
            </resources>
        </configuration>
    </plugin>
    
## 2、docker maven插件执行方式：
### 2.1、使用maven命令执行构建，如：
   生成镜像命令：mvn docker:build 
   
   生成镜像并上传到registry，默认是上传到Docker Hub公共Registry,可以指定参数上传到私有Registry：mvn docker:build -DpushImage
   
   上传imageTags元素指定的标记到Registry，如：mvn docker:build -DpushImage
   
   上传参数指定的标记到Registry，如：mvn docker:build -DpushImageTag -DdockerImageTags=latest,another-tag
   
   删除镜像：mvn docker:removeImage
   
   删除指定镜像：mvn docker:removeImage -DimageName=foobar


### 2.2、绑定到maven构建生命周期阶段，如：
   绑定插件目标到maven生命周期阶段，当maven构建到该阶段时，会自动执行插件的目标。如package阶段绑定build目标生成镜像，以及绑定tag目标生成不同的镜像标记方便发布到Regis try中；install阶段或者deploy阶段绑定push目标，上传镜像到指定的Registry，pom如：
    
    <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>docker-maven-plugin</artifactId>
        <version>0.4.11</version>
        <configuration>
            <!--基础配置和上面一致-->
            ...
        </configuration>

        <!-- 绑定到maven生命周期阶段-->
        <executions>
            <!--删除历史镜像-->
            <execution>
                <id>remove-image</id>
                <phase>package</phase>
                <goals>
                    <goal>removeImage</goal>
                </goals>
            </execution>

            <!--生成镜像-->
            <execution>
                <id>build-image</id>
                <phase>package</phase>
                <goals>
                    <goal>build</goal>
                </goals>
            </execution>
            
            <!--标记镜像-->
            <execution>
                <id>tag-image</id>
                <phase>package</phase>
                <goals>
                    <goal>tag</goal>
                </goals>
                <configuration>
                    <image>${project.artifactId}:${project.version}</image>
                    <newName>${docker.image.prefix}/${project.artifactId}:${project.version}</newName>
                </configuration>
            </execution>
        </executions>
    </plugin>

   绑定后，构建时同样也可以通过参数，跳过绑定的目标如：
    
    -DskipDockerBuild  跳过build目标

    -DskipDockerTag  跳过tag目标

    -DskipDockerPush 跳过push目标

    -DskipDocker to 跳过所有docker插件目标  
