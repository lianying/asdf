/**   
* @Title: VasApi.java 
* @Package com.thinkgem.jeesite.modules.top.service.topapi 
* @Description: TODO
* @author 10060484
* @date 2013-3-28 下午2:17:48 
* @version V1.0   
*/
package com.thinkgem.jeesite.modules.top.service.topapi;

import java.util.List;

import com.taobao.api.domain.ArticleUserSubscribe;
import com.taobao.api.request.VasSubscribeGetRequest;

/**
 * @author 10060484
 *
 */
public class VasApi {

	private ImprovedTaobaoClient taobaoClient;
	
	public VasApi(ImprovedTaobaoClient taobaoClient) {
		this.taobaoClient = taobaoClient;
	}
	
	public List<ArticleUserSubscribe> getVasSubscribe(String nick, String articleCode) {
		VasSubscribeGetRequest request = new VasSubscribeGetRequest();
		request.setNick(nick);
		request.setArticleCode(articleCode);
		
		return taobaoClient.execute(request).getArticleUserSubscribes();
	}
	
}
