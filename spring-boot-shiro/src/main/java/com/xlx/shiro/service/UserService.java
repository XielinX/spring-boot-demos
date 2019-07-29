package com.xlx.shiro.service;

import com.xlx.shiro.dao.UserMapper;
import com.xlx.shiro.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
   * @param userName 登录帐号
   */
  public User findUserByUserName(String userName){
    return userMapper.selectUserByUserName(userName);
  }




  /**
   * 登录成功更新登录时间
   * @param userName .
   * @param loginDate .
   */
  public boolean recordLoginDate(String userName, Date loginDate){
    return userMapper.updateLoginDate(userName,loginDate) != 0;
  }

  /**
   * 分页
   * @param page 偏移量
   * @param size 笔数
   * @return list
   */
  public List<User> listUserPage(Integer page,Integer size){
    int offset = (page - 1) * size;
    return userMapper.selectUserByPage(offset,size);
  }
}

