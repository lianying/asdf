package com.thinkgem.jeesite.modules.top.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.top.entity.TopUser;
import com.thinkgem.jeesite.modules.top.service.TopUserService;

/**
 * top用户Controller
 * @author lay
 * @version 2013-03-22
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/modules/top/user")
public class TopUserController extends BaseController {

	@Autowired
	private TopUserService userService;
	
	@ModelAttribute
	public com.thinkgem.jeesite.modules.top.entity.TopUser get(@RequestParam(required=false) Long id) {
		if (id != null){
			return userService.get(id);
		}else{
			return new TopUser();
		}
	}

	@RequiresPermissions("top:user:view")
	@RequestMapping(value = "form")
	public String form(TopUser user, Model model) {
		model.addAttribute("user", user);
		return "modules/top/userForm";
	}

}
