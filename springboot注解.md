# springboot注解

## 1，@RefreshScope

作用：实现配置文件的动态加载



使用方法：

修改配置文件后，不重启应用。

1. 在需要读取配置文件的地方添加 `@RefreshScope`注解
2. 发送POST请求：`http://localhost:port/actuator/refresh`。
   然后在重新发送controller层的请求，发现配置文件的更新已经生效了。

适用场景：
1. Springcloud的config分布式配置中心：
springcloud中各个模块的配置统一放置在 github上，通过springconfig的server端远程访问github获取指定的配置文件信息。然后springconfig的client端，读取server端的信息。
此时存在的问题：当github上的配置文件更新后，springconfig的server端的读取的是更新后的文件，但是springconfig的client端不能直接更新，读取的还是之前的旧的配置。
解决办法：

重新启动springconfig的client端的模块程序。（麻烦，当springcloud的模块很多的时候，重启是非常耗费时间的，而且程序在部署之后，可能不允许我们重启程序）

使用@RefreshScope注解 + POST请求（对所有的ConfigClinet客户端，运维人员都要发送一次POST请求，麻烦）。

使用BUS消息总线。
一次修改，广播通知，处处生效：curl -X POST “http://localhost:3344/actuator/bus-refresh”。
不想全部通知，只想定点通知：curl -X POST “http://localhost:3344/actuator/bus-refresh/config-client:3355” （其中config-client是spring.application.name， 3355是server.port。