# springboot-shiro-arthur





### 登陆

使用postman，因为发的是post请求。

```url
http://localhost:8080/arthur-boot/sys/login?password=111&username=arthur
```



### 测试接口访问

在postman中发get请求时，在header中，key:Authorization,value为登陆时返回的token值

```
http://localhost:8080/arthur-boot/test/require_role
```

