package com.xlx.shiro.service;

import com.xlx.shiro.dao.MenuMapper;
import com.xlx.shiro.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 资源
 *
 * @author xielx on 2019/7/28
 */
@Service
public class MenuService {

	@Autowired
	private MenuMapper menuMapper;


	/**
	 * 根据帐号获取该用户的权限集
	 * @param userName 登录帐号
	 */
	public Set<String> getPermissions(String userName){
		return menuMapper.selectPermissionsByUserName(userName);
	}


	/**
	 * 根据账户获取对应的资源管理菜单
	 * @param userName 登录账户
	 * @return list
	 */
	public List<Menu> listMenusOfLoginer(String userName){

		return  null;
	}
}
