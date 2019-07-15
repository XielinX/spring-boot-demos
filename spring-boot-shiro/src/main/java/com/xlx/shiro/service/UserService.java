package com.xlx.shiro.service;

import com.xlx.shiro.dao.UserMapper;
import com.xlx.shiro.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;

/**
 * service:user
 *
 * @author xielx on 2019/7/13
 */
@Service
public class UserService {

  @Resource
  private UserMapper userMapper;


  /**
   * 根据帐号获取用户
   * @param account 登录帐号
   * @return user
   */
  public User findUserByUserAccount(String account){
    return userMapper.selectUserByUserAccount(account);
  }

  /**
   * 根据帐号获取该用户的权限集
   * @param account 登录帐号
   * @return set
   */
  public Set<String> getPerminssions(String account){
    return userMapper.selectPermissionsByUserAccount(account);
  }

  /**
   * 根据帐号获取该用户的角色集
   * @param account 登录帐号
   * @return set
   */
  public Set<String> getRoles(String account){
    return userMapper.selectRolesByUserAccount(account);
  }

  /**
   * 登录成功更新登录时间
   * @param userAccount .
   * @param loginDate .
   * @return .
   */
  public boolean recordLoginDate(String userAccount, Date loginDate){
    return userMapper.updateLoginDate(userAccount,loginDate) != 0;
  }
}
