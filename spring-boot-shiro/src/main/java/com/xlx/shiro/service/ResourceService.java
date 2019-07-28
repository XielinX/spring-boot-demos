package com.xlx.shiro.service;

import com.xlx.shiro.dao.ResourceMapper;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 资源
 *
 * @author xielx on 2019/7/28
 */
public class ResourceService {

	@Resource
	private ResourceMapper resourceMapper;


	/**
	 * 根据帐号获取该用户的权限集
	 * @param userName 登录帐号
	 */
	public Set<String> getPermissions(String userName){
		return resourceMapper.selectPermissionsByUserName(userName);
	}
}
