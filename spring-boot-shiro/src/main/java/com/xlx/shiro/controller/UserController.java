package com.xlx.shiro.controller;

import com.xlx.shiro.common.util.DateUtil;
import com.xlx.shiro.common.util.JwtUtil;
import com.xlx.shiro.dto.ResultDTO;
import com.xlx.shiro.entity.User;
import com.xlx.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户
 *
 * @author xielx on 2019/7/14
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @Resource
  private UserService userService;

  /**
   * 登录
   * 思路:
   * 登录成功,就创建一个token(有效时间:登录时间+10min)
   * @param username
   * @param password
   * @return
   */
  @RequestMapping("/login")
  @Transactional
  public ResultDTO login(@RequestParam(name = "username") String username,@RequestParam(name = "password")String password){
    log.info("username:[{}],password:[{}]",username,password);
    //TODO  检验参数的完整性

    User user = userService.findUserByUserAccount(username);
    //检验username是否存在
    if(user!=null){
      //检验密码是否正确
      if(!user.getUserPassword().equals(password)) {

        return ResultDTO.failed(1001,"用户名或密码错误");
      }
    }
    //登录成功,更新登录时间?数据库插入有延迟1ms
    Date loginDate = new Date();
    log.info("记录登录时间:[{}]", DateUtil.formatString(loginDate));
    userService.recordLoginDate(username,loginDate);
    return ResultDTO.success("登录成功",JwtUtil.generateToken(username,loginDate));
  }


}
