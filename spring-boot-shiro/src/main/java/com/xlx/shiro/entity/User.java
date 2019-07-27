package com.xlx.shiro.entity;

import java.util.Date;

public class User {
    private Long userId;

    private Long deptId;

    private String avatarName;

    private String avatarUrl;

    private String userName;

    private String userReal;

    private String userPassword;

    private String salt;

    private String token;

    private Integer gender;

    private Date birth;

    private String mail;

    private String phone;

    private Boolean locked;

    private String loginIp;

    private Date loginDate;

    private Date gmtCreate;

    private Date gmtModified;

    public User(Long userId, Long deptId, String avatarName, String avatarUrl, String userName, String userReal, String userPassword, String salt, String token, Integer gender, Date birth, String mail, String phone, Boolean locked, String loginIp, Date loginDate, Date gmtCreate, Date gmtModified) {
        this.userId = userId;
        this.deptId = deptId;
        this.avatarName = avatarName;
        this.avatarUrl = avatarUrl;
        this.userName = userName;
        this.userReal = userReal;
        this.userPassword = userPassword;
        this.salt = salt;
        this.token = token;
        this.gender = gender;
        this.birth = birth;
        this.mail = mail;
        this.phone = phone;
        this.locked = locked;
        this.loginIp = loginIp;
        this.loginDate = loginDate;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public User() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName == null ? null : avatarName.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserReal() {
        return userReal;
    }

    public void setUserReal(String userReal) {
        this.userReal = userReal == null ? null : userReal.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}