package com.xlx.shiro.shiro.realm;

import com.xlx.shiro.entity.User;
import com.xlx.shiro.service.MenuService;
import com.xlx.shiro.service.RoleService;
import com.xlx.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 自定义的Realm
 *
 * @author xielx on 2019/7/13
 */
public class UserRealm extends AuthorizingRealm {

  private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

  @Resource
  private RoleService roleService;

  @Resource
  private MenuService menuService;
  @Resource
  private UserService userService;
  /**
   * 权限认证
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    logger.info("===================权限认证===============");
    //String username = (String) principals.getPrimaryPrincipal();
    User user = (User) principals.getPrimaryPrincipal();
    Set<String> roleSet = roleService.getRoles(user.getUserName());
    Set<String> permsSet = menuService.getPermissions(user.getUserName());
    logger.info("用户[{}]的角色集[{}]:",user.getUserName(),roleSet);
    logger.info("用户[{}]的权限集[{}]",user.getUserName(),permsSet);

    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    authorizationInfo.setRoles(roleSet);
    authorizationInfo.setStringPermissions(permsSet);
    return authorizationInfo;
  }

  /**
   * 身份认证
   * simpleAuthenticationInfo构造方法第一个参数Object principal
   * 若传入用户名,subject.getPrincipal()返回的就是String
   * 若传入对象,subject.getPrincipal()返回的就是对象
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    logger.info("==============身份认证==================");
    UsernamePasswordToken upToken = (UsernamePasswordToken) token;
    String username = upToken.getUsername();
    logger.info("userAccount:[{}]",username);
    User user = userService.findUserByUserName(username);
    logger.info("查询出的用户[{}]=", user);
    if (user == null) {
      throw new UnauthenticatedException("帐号或密码错误");
    }

    if (Boolean.TRUE.equals(user.getLocked())) {
      throw new LockedAccountException("帐号被锁定,请联系管理员");
    }


    // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配,也可自定义
    SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,
            user.getUserPassword(),
            ByteSource.Util.bytes(user.getCredentialsSalt()),
            getName());

    return simpleAuthenticationInfo;
  }


  @Override
  protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
    super.clearCachedAuthorizationInfo(principals);
  }

  @Override
  protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
    super.clearCachedAuthenticationInfo(principals);
  }

  @Override
  protected void clearCache(PrincipalCollection principals) {
    super.clearCache(principals);
  }


}
