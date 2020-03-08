package com.xlx.thirdpartoauth.dto;

/**
 * 认证访问的tokenDTO
 * @Author xielx on 2019/6/21
 */
public class GiteeAccessTokenDTO  extends AbstractAccessToken{

  /**
   *
   */
  private String grant_type;
  /**
   * 随机字符串
   */
  private String state;
  
  public GiteeAccessTokenDTO(String code, String client_id, String client_secret, String redirect_uri, String grant_type, String state) {
    super(code, client_id, client_secret, redirect_uri);
    this.grant_type = grant_type;
    this.state = state;
  }
  
  public GiteeAccessTokenDTO(String grant_type, String state) {
    this.grant_type = grant_type;
    this.state = state;
  }
  
  public String getGrant_type() {
    return grant_type;
  }
  
  public void setGrant_type(String grant_type) {
    this.grant_type = grant_type;
  }
  
  public String getState() {
    return state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
}