## 登录逻辑

### 用户名密码登录
接收前端输入用户名、密码
shiro对用户名、密码进行验证
```
if 登录成功 then
    生成token
    将token传递给前台
        示例json:{code:"200", message:"登录成功", token:"abc123"}
    记录登录日志
else
    返回登录失败的返回码和错误信息
        示例json:{code:"301", message:"用户不存在"}
        示例json:{code:"302", message:"用户名或密码不正确"}
endif
```

### 记住密码直接登录

### 其他方式登录
微信、微博、QQ、github