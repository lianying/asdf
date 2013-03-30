package com.thinkgem.jeesite.modules.top.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.top.entity.Item;
import com.thinkgem.jeesite.modules.top.service.ItemService;

/**
 * 淘宝商品Controller
 * @author lay
 * @version 2013-03-18
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/modules/top/item")
public class ItemController extends BaseController {

	@Autowired
	private ItemService itemService;
	
	@ModelAttribute
	public Item get(@RequestParam(required=false) Long id) {
		if (id != null){
			return itemService.get(id);
		}else{
			return new Item();
		}
	}
	
//	@RequiresPermissions("top:item:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(Item item, Model model) {
//		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			item.setUser(user);
//		}
//        Page<Item> page = itemService.find(new Page<Item>(request, response), item); 
//        model.addAttribute("page", page);
//		return "modules/top/itemList";
//	}

	@RequiresPermissions("top:item:view")
	@RequestMapping(value = "form")
	public String form(Item item, Model model) {
		model.addAttribute("item", item);
		return "modules/top/itemForm";
	}

//	@RequiresPermissions("top:item:edit")
//	@RequestMapping(value = "save")
//	public String save(Item item, RedirectAttributes redirectAttributes) {
//		if (beanValidators(redirectAttributes, item)){
//			itemService.save(item);
//			addFlashMessage(redirectAttributes, "保存淘宝商品'" + item.getName() + "'成功");
//		}
//		return "redirect:"+BaseController.ADMIN_PATH+"/modules/top/item/?repage";
//	}
	
	@RequiresPermissions("top:item:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		itemService.delete(id);
		//addFlashMessage(redirectAttributes, "删除淘宝商品成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/top/item/?repage";
	}

}
