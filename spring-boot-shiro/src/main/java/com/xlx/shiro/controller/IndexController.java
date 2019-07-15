package com.xlx.shiro.controller;

import com.xlx.shiro.common.util.JwtUtil;
import com.xlx.shiro.dto.ResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * index
 *
 * @author xielx on 2019/7/14
 */
@RestController
public class IndexController {


  /**
   * 验证token是否过期
   * @param request
   * @return
   */
  @GetMapping("/index")
  public ResultDTO login(HttpServletRequest request){
    String token = request.getParameter("token");
    return JwtUtil.validateToken(token);
  }


  /**
   * 前端请求刷新过期的token
   * @return
   */
  @GetMapping("/fresh")
  public ResultDTO freshToken(){
    // 标记授权为true
    boolean authorized = true;
    return ResultDTO.success(authorized);
  }
}
