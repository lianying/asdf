/**   
 * @Title: TopCallbackController.java 
 * @Package com.thinkgem.jeesite.modules.top.web 
 * @Description: TODO
 * @author 10060484
 * @date 2013/03/21 14:18:31 
 * @version V1.0   
 */
package com.thinkgem.jeesite.modules.top.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taobao.api.domain.ArticleUserSubscribe;
import com.taobao.api.internal.util.WebUtils;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.PropertiesLoader;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.top.service.topapi.VasApi;
import com.thinkgem.jeesite.modules.top.utils.TopConifg;

/**
 * @author 10060484
 * 
 */
@Controller
@RequestMapping(value = "top")
public class TopCallbackController extends BaseController {

	private static final PropertiesLoader prop;
	static {
		prop = new PropertiesLoader("classpath:/top-config.properties");
	}

	private SystemService systemService;
	private VasApi vasApi;

	@ResponseBody
	@RequestMapping(value = "callback")
	public String callback(@RequestParam("code") String code,
			HttpServletResponse response) throws IOException {

		// 生成或更新用户
		User user;
		try {
			user = getUser(code, response);
		} catch (IOException e) {
			throw e;
		}

		// 登录
		systemService.login(user.getLoginName(), user.getPassword());

		// 跳转
		

		return "redirect:" + Global.ADMIN_PATH;
	}

	@RequestMapping(value = "sendtologin")
	public String sendToLogin() {
		return String.format("redirect:" + TopConifg.getOauthUrl(),
				TopConifg.getAppKey(), TopConifg.getRedirectUrl());
	}

	private User getUser(String code, HttpServletResponse response) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", prop.getProperty("app_key"));
		params.put("response_type", "code");
		params.put("client_secret", prop.getProperty("app_secret"));
		params.put("grant_type", "authorization_code");
		params.put("code", code);
		params.put("redirect_uri", prop.getProperty("redirect_uri"));

		String res = WebUtils.doPost(TopConifg.getOauthCodeUrl(), params,
				0, 0);

		if (StringUtils.isBlank(res)) {
			return null;
		}

		//根据TOP回调的参数给用户赋值
		User user = JsonMapper.getInstance().fromJson(res, User.class);
		user.setLoginName(user.getTaobaoUserNick());
		user.setName(user.getTaobaoUserNick());
		user.setPassword(SystemService.entryptPassword(user.getLoginName()));

		//查询用户的版本
		List<ArticleUserSubscribe> vasSubscribe = vasApi.getVasSubscribe(user.getTaobaoUserNick(),
				TopConifg.getArticleCode());
		for (ArticleUserSubscribe subscribe : vasSubscribe) {
			subscribe.getItemCode();
			subscribe.getDeadline();
			
		}
		
		//保存
		systemService.saveUser(user);

		//登录
		systemService.login(user.getLoginName(), user.getPassword());

		return user;
	}
}
