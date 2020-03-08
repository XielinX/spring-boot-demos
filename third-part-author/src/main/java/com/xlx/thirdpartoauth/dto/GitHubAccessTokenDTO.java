package com.xlx.thirdpartoauth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * GitHub授权时的参数封装
 * https://github.com/login/oauth/access_token?
 *
 * @Author xielx on 2019/6/21
 */
public class GitHubAccessTokenDTO extends AbstractAccessToken {
    
    /**
     *
     */
    private String state; // 随机字符串
    
    public GitHubAccessTokenDTO(String code, String client_id, String client_secret, String redirect_ur, String state) {
        super(code, client_id, client_secret, redirect_ur);
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}
