## 整套权限系统设计思路

后台用户权限
- 用户-角色表
- 角色表
- 角色-菜单表
- 菜单表
- 角色-权限表
- 权限表 包含所属菜单的字段

页面上涉及到权限的内容
- 登陆
- 菜单
- 直接访问url
- 数据列表
- 按钮
- 其他请求

未登陆

登陆时
- 后端查询用户能访问的所有菜单，封装到json中，传递给前端
- 前端根据json生成菜单列表，存到sessionStorage中
- 前端根据json生成动态路由，存到sessionStorage中（防止直接访问url）

渲染页面时
- 后端查询用户能访问的该页面的权限
- 前端根据权限判断是否显示按钮
- 前端根据权限判断按钮点击跳转的页面（功能页面还是405页面，防止手动修改css显示按钮）

页面跳转前
- 后端开放checkLoginStatus接口，根据sessionId判断登陆的用户，并返回给前端 √
- 前端设立统一的路由拦截器，在跳转之前进行登陆状态认证，如果认证失败，则返回登陆界面

ajax请求响应时
- 后端判断请求方是否为登陆用户，如果未登陆，返回一个统一的失败返回码 √ 继承Shiro的FormAuthenticationFilter
- 前端设立统一的响应拦截器，在响应时如果返回码是未登陆，跳转至登陆界面 √ request.js

注意
- 有菜单访问权限必须有数据列表权限，否则页面会出错

