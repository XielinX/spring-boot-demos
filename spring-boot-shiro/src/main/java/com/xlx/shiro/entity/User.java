package com.xlx.shiro.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private Long userId; //主键

	private Long deptId; // 部门id

	private String avatarName; // 昵称

	private String avatarUrl; //头像url

	private String userName; //用户名

	private String userReal; //真实姓名

	private String userPassword; //密码

	private String salt; //盐值

	private String token; //cookie使用

	private Integer gender; //性别,1:男;0女

	@JSONField(format = "yyyy-MM-dd")
	private Date birth; //出生日期

	private String mail; //邮箱

	private String phone; //电话

	private Boolean locked; //不锁定

	private String loginIp; // 登录ip

	private Date loginDate; //最后登录时间

	private Date gmtCreate; //创建时间

	private Date gmtModified; //修改时间


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

	/**
	 * 盐 = 用户名 + salt
	 *
	 * @return
	 */
	public String getCredentialsSalt() {
		return userName + salt;
	}

	public User() {}

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
		this.avatarName = avatarName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserReal() {
		return userReal;
	}

	public void setUserReal(String userReal) {
		this.userReal = userReal;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		this.loginIp = loginIp;
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