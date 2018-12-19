前后端分离架构，很多团队都是通过“代理转发”浏览器发往后端的rest请求来解决跨域问题，可以用nginx或者node.js模块http-proxy-middleware实现代理。以下是部署架构，在此架构中你把node换成nginx依然成立。

![node_spring_boot](https://github.com/lhing17/rocket/doc/images/node_spring_boot.jpg)

Node.js前端服务器的职责:

作为静态文件服务器，当用户访问网站的时候，将index.html以及其引入的js、css、fonts以及图片返回给用户
负责将客户端发来的ajax请求转发给后台服务器。