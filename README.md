## Rocket快速开发平台

总体指导原则：简单大于正确

**规划模块**
- 权限管理
- 定时任务
- 文件管理
- 代码生成器
- 工作流
- 系统监控 服务器监控、缓存监控
- SQL监控
- 消息推送

**规划特性**
- 分布式部署
- 防范攻击
- 前后端分离
- 多种数据库支持、多数据源支持
- session共享
- 数据字典

**规划技术选型**
- MVC框架 spring + spring mvc + mybatis
- 权限管理 spring security / shiro
- 文件管理 oss
- 数据库连接 druid
- 消息推送 jpush / rabbitmq
- 缓存层 redis

**落地技术选型**
- 前端 vue
- 前后端分离中间层 node.js (express)
- 后端全局框架 spring boot
