/**   
 * @Title: TopServlet.java 
 * @Package com.thinkgem.jeesite.modules.top.web 
 * @Description: TODO
 * @author 10060484
 * @date 2013/03/19 10:16:46 
 * @version V1.0   
 */
package com.thinkgem.jeesite.modules.top.web;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.taobao.api.response.ItemsOnsaleGetResponse;
import com.thinkgem.jeesite.common.utils.PropertiesLoader;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.top.service.ItemService;

/**
 * @author 10060484
 * 
 */
public class TopServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final PropertiesLoader prop;
	static {
		prop = new PropertiesLoader("classpath:/top-config.properties");
		
	}
	
	private static final String serverUrl = "http://gw.api.taobao.com/router/rest";
	private static final String appKey = "21056818";
	private static final String appSecret = "cfeae196784dc0b44889855af3f3b5ca";
	private static final String session = "6201919a1aa767cb7d7d75e0fccegaaaef7e7339ddaefd9876248007";

	@Autowired
	private SystemService systemService;
	@Autowired
	private ItemService itemService;

	@Override
	public void init() throws ServletException {

		ServletContext sc = this.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(sc);
		this.itemService = (ItemService) ctx.getBean("itemService");

		System.out.println(itemService);
		sync();
	}

	private void sync() {

		System.out.println(itemService);

		ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
		request.setFields("approve_status,num_iid,title,nick,type,cid,pic_url,num,props,valid_thru,list_time,price,has_discount,has_invoice,has_warranty,has_showcase,modified,delist_time,postage_id,seller_cids,outer_id");
		TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey,
				appSecret);
		
		try {
			ItemsOnsaleGetResponse response = client.execute(request, session);
			if (response.isSuccess()) {
				System.out.println("success");
				List<Item> items = response.getItems();
				for (Item item : items) {
					com.thinkgem.jeesite.modules.top.entity.Item i = new com.thinkgem.jeesite.modules.top.entity.Item();
					PropertyUtils.copyProperties(i, item);
					System.out.println(i.getTitle());
					itemService.save(i);
				}
			} else {
				System.out.println("fail: " + response.getMsg());
			}
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
