# spring-boot-shiro
## 技术
+ `Spring-Boot`
+ `Mybatis`
+ `Shiro`
+ `Ehcache`
+ `Thymeleaf`


#### 2019年7月12日
+ **RBAC:基于角色/资源的访问控制**
> 基于角色/role
```java
//假设只有项目组长monitor角色,才有权限查看核心代码
if(user.hasRole("monitor)){
  //do something
}
//现在需求变更,项目经理manager角色也能查看
if(user.hasRole("monitor") || user.haoRole("manager")){
  //do something
}
//可以看出,如果角色频繁变更,代码判断逻辑也要频繁的修改
```

> 基于资源 /resource
```java
//权限判断与角色无关,只判断是否拥有该字符权限
if(user.hasPermission("project:core:view")){
  //do something
}
/*这样用户权限变更,只需修改数据库中用户对应角色的权限,而权限与对应的资源通常不需改变
 * 基于资源方式,仍然需要角色,用户权限分配依据角色(例如:admin角色,同时会有CRUD权限)
 * 访问控制时,不判断角色,只关心是否拥有该权限,有就可访问
 * /
```
## 问题
+ 问题1 
  为什么项目重启,第一次登录操作 **POST** `http://localhost:8887/login`,不走Controller里的`/login`方法,直接自己登录验证,跳转
  等到第二次才走?
