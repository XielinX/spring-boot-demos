package com.xlx.thirdpartoauth.controller;

import com.xlx.thirdpartoauth.dto.AbstractAccessToken;
import com.xlx.thirdpartoauth.dto.GitHubAccessTokenDTO;
import com.xlx.thirdpartoauth.provider.GitHubProvider;
import com.xlx.thirdpartoauth.provider.GitHubUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * github认证
 *
 * @author xielx on  2019/6/21
 * To change this template use File | Settings | Editor | File and Code Templates.
 */
@Slf4j
@Controller
public class GithubController {

  @Value("${github.client.id}")
  private String clientId;
  @Value("${github.client.secret}")
  private String clientSecret;
  @Value("${github.redirect.uri}")
  private String redirectUri;



  @Resource
  private GitHubProvider gitHubProvider;





  /**
   *  github认证后,进行回调uri
   * @param code .
   * @param state .
   * @param response .
   * @return str
   */
  @GetMapping("/callback")
  public String callback(@RequestParam(name = "code") String code,
                         @RequestParam(name = "state") String state,
                         HttpServletResponse response) {

    AbstractAccessToken accessTokenDTO = new GitHubAccessTokenDTO(clientId,clientSecret,code,redirectUri,state);

    // 经过授权,获取access_token
    String  accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
    // 根据提供的access_token获取用户信息
    GitHubUser gitHubUser = gitHubProvider.getGitHubUser(accessToken);
    if(gitHubUser != null && gitHubUser.getId() != null){
      // 数据库操作,记录第三方账号信息
  
    }else {
      //登录失败,重写登录
    }
    return "redirect:/";
  }










}
