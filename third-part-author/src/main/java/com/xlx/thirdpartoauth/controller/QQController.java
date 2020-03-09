package com.xlx.thirdpartoauth.controller;

import com.xlx.thirdpartoauth.dto.GiteeAccessTokenDTO;
import com.xlx.thirdpartoauth.dto.ResultDTO;
import com.xlx.thirdpartoauth.provider.QQProvider;
import com.xlx.thirdpartoauth.entity.QQUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * QQ
 *
 * @author xielx at 2020/3/8 16:53
 */
@Controller
public class QQController {
    
    @Value("${qq.client.id}")
    private String clientId;
    @Value("${qq.client.secret}")
    private String clientSecret;
    @Value("${qq.redirect.uri}")
    private String redirectUri;
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Resource
    private QQProvider qqProvider;
    
    /**
     * 调用回调函数
     *
     * @param code  认证后返回的code值,有效期:10min
     * @param state 原state值,校验状态值,防止CSRF攻击
     * @return html
     */
    @GetMapping("/callbackToQQ")
    @ResponseBody
    public ResultDTO callBack(@RequestParam("code") String code, @RequestParam("state") String state) {
        logger.info("code={}", code);
        logger.info("state={}", state);
        
        GiteeAccessTokenDTO accessTokenDTO = new GiteeAccessTokenDTO(code, clientId, clientSecret, redirectUri, "authorization_code", state);
        
        // 获取Access_Token
        final String accessToken = qqProvider.getAccessToken(accessTokenDTO);
        // 校验token过期
        // openId
        final String openId = qqProvider.getOpenId(accessToken);
        // QQ用户信息
        QQUser qqUser = qqProvider.getUserInfo(accessToken, clientId, openId);
        return ResultDTO.success(qqUser);
    }
    
    
    public String refreshToken() {
        // refreshToken是从第一次获取accessToken中返回的
        GiteeAccessTokenDTO refreshToken = new GiteeAccessTokenDTO(clientId, clientSecret, "refresh_token", "");
        
        final String accessToken = qqProvider.getAccessToken(refreshToken);
        return accessToken;
    }
}
