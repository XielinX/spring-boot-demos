package com.xlx.thirdpartoauth.controller;

import com.xlx.thirdpartoauth.dto.GiteeAccessTokenDTO;
import com.xlx.thirdpartoauth.dto.GiteeUser;
import com.xlx.thirdpartoauth.dto.ResultDTO;
import com.xlx.thirdpartoauth.enums.ErrorCodeEnum;
import com.xlx.thirdpartoauth.provider.GiteeProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * 码云认证
 *
 * @author xielx on 2019/8/5
 */
@Slf4j
@Controller
public class GiteeController {
    
    @Value("${gitee.client.id}")
    private String clientId;
    @Value("${gitee.client.secret}")
    private String clientSecret;
    @Value("${gitee.redirect.uri}")
    private String redirectUri;
    
    @Autowired
    private GiteeProvider giteeProvider;
    
    /**
     * 回调,先获取密钥,再获取用户信息
     *
     * @param code     code
     * @param response .
     * @return .
     */
    @GetMapping("/callbackToMY")
    public ResultDTO callbackToMY(@RequestParam(name = "code") String code,
                                  @RequestParam(name = "state") String state,
                                  HttpServletResponse response) {
        GiteeAccessTokenDTO tokenDTO = new GiteeAccessTokenDTO(code, clientId, clientSecret,redirectUri,"authorization_code",state);
        
        String accessToken = giteeProvider.getAccessToken(tokenDTO);
        log.info("token:[{}]", accessToken);
        
        GiteeUser giteeUser = giteeProvider.getUserInfo(accessToken);
        if (giteeUser != null && giteeUser.getId() != null) {
            // 数据库操作,存储第三方用户信息
            return ResultDTO.success(giteeUser);
        }
        return ResultDTO.failed(ErrorCodeEnum.GET_USER_INFO_FAILED,new GiteeUser());
        
    }
}
