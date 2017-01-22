#JDocker
基于 Docker1.12+ (Docker API 1.24+) 开发出的开发包，通过封装 Docker API 使开发者可以快速的使用 Java 开发出控制和操作 Docker 的应用，使用流式操作,简单明了。

完善的测试用例覆盖率达87%。

####JDocker 是 Voovan 开源项目的一个子项目,自然是依赖于 voovan开源项目的。

![](http://git.oschina.net/uploads/images/2016/0510/122514_7d971a34_116083.jpeg)

------------------------
####重要更新
 - 2017-01-22 增加对 Docker Api 1.25 的支持。
 - 2016-12-05 完成 Docker Api 1.24 的支持。
------------------------

对 Voovan 项目的Maven依赖:
```xml
<dependency>
    <groupId>org.voovan</groupId>
    <artifactId>voovan-framework</artifactId>
    <version>1.0-beta-*</version>
</dependency>
```
通过设置`org.voovan.docker.DockerGlobal`中的环境变量来连接至 Docker。
```java
    public static String DOCKER_REST_HOST = "127.0.0.1";
    public static int DOCKER_REST_PORT = 2735;
    public static String DOCKER_REST_CHARSET = "UTF-8";
    public static int DOCKER_REST_TIMEOUT = 5;
    public static boolean DEBUG = false;
```

使用 JDocker 创建一个容器:

```java
        //构造一个创建命令
        CmdContainerCreate createCmd =  CmdContainerCreate.newInstance("d_test");
        //使用流式操作来创建容器
        Object data = createCmd.image("alpine").network("bridge")
                .volume("v_tx:/v_tx").link("dockerfly:dockerfly")
                .cmd("ping","127.0.0.1").env("author=helyho")
                .exposePort(22,"tcp","2222").send();
        createCmd.close();
        Logger.info(formatJSON(data));
```

具体使用请参照 `org.voovan.docker.test.command`测试用例。