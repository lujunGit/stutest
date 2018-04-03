springCloud生态项目

1：scConfigClient
   springCloud配置客户端，通过连接配置服务器实现外置外联
2：scConfigServer
   springCloud配置服务器，把配置文件放在外部服务器，通过配置读取
3：scEurekaClient
   springCloud服务注册客户端（把接口服务注册到接口服务器上），配置接口服务器
4：scEurekaServer
   springCloud服务注册服务端，配置接口服务器，用来接送客户服务的注册
5：scFeign
   springCloud服务使用端，配置服务注册的服务器，使用注册服务器中的接口服务
6：scRibbon
   springCloud服务使用端，配置服务注册的服务器，使用注册服务器中的接口服务，可以查看接口的调用情况以及成功失败百分比
7：scZuul
   springCloud服务接口路由，通过配置请求的正则表达式，来匹配请求的服务接口名称
   
8：qq群里共享的springCloud项目：
   https://github.com/xubinux/xbin-store
 
9：https://github.com/dyc87112/SpringCloud-Learning