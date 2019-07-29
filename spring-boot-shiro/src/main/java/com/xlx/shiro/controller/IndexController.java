package com.xlx.shiro.controller;

import com.xlx.shiro.common.util.ShiroUtil;
import com.xlx.shiro.entity.Menu;
import com.xlx.shiro.entity.User;
import com.xlx.shiro.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * index
 *
 * @author xielx on 2019/7/22
 */
@Controller
public class IndexController extends BaseController {

	@Resource
	private MenuService menuService;

	@GetMapping("/index")
	public String index(Model model){
		User user = (User) ShiroUtil.getSubject().getPrincipal();

  	List<Menu> menusList = menuService.listMenusOfLoginer(user.getUserName());
		model.addAttribute("menusList",menusList);
    model.addAttribute("user",user);
		return "index";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}
}
