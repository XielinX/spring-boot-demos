package com.xlx.shiro.service;

import com.xlx.shiro.dao.RoleMapper;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 角色
 *
 * @author xielx on 2019/7/28
 */
public class RoleService {

	@Resource
	private RoleMapper roleMapper;


	/**
	 * 根据帐号获取该用户的角色集
	 * @param userName 用户名
	 * @return set
	 */
	public Set<String> getRoles(String userName) {
		return roleMapper.selectRoleKeyByUserName(userName);
	}

}
