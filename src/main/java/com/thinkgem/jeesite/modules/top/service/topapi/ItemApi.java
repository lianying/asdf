/**   
 * @Title: ItemApi.java 
 * @Package com.thinkgem.jeesite.modules.top.service.topapi 
 * @Description: TODO
 * @author 10060484
 * @date 2013/03/22 14:18:06 
 * @version V1.0   
 */
package com.thinkgem.jeesite.modules.top.service.topapi;

import java.util.List;

import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemRecommendAddRequest;
import com.taobao.api.request.ItemRecommendDeleteRequest;
import com.taobao.api.request.ItemsInventoryGetRequest;
import com.taobao.api.request.ItemsListGetRequest;
import com.taobao.api.request.ItemsOnsaleGetRequest;

/**
 * @author 10060484
 * 
 */
public class ItemApi {

	private static final String FULL_INFO_FIELDS = "approve_status,num_iid,title,nick,type,cid,pic_url," +
			"num,props,valid_thru,list_time,price,has_discount,has_invoice,has_warranty,has_showcase," +
			"modified,delist_time,postage_id,seller_cids,outer_id";

	private ImprovedTaobaoClient taobaoClient;

	public ItemApi(ImprovedTaobaoClient taobaoClient) {
		this.taobaoClient = taobaoClient;
	}

    public void addRecommend(Long numIid, String session) {
    	ItemRecommendAddRequest request = new ItemRecommendAddRequest();
    	request.setNumIid(numIid);
    	
		taobaoClient.execute(request, session);
	}
    
    public void deleteRecommend(Long numIid, String session) {
		ItemRecommendDeleteRequest request = new ItemRecommendDeleteRequest();
		request.setNumIid(numIid);
		
		taobaoClient.execute(request, session);
	}
    
    public List<Item> getOnsaleItems(final String session, int pageNo) {
    	ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
		request.setFields(FULL_INFO_FIELDS);

		return taobaoClient.execute(request, session).getItems();
	}
    
    public List<Item> getInventoryItems(final String session, int pageNo) {
    	ItemsInventoryGetRequest request = new ItemsInventoryGetRequest();
    	request.setFields(FULL_INFO_FIELDS);
    	
		return taobaoClient.execute(request).getItems();
	}

	public List<Item> getItems(String numIids, String session) {
		ItemsListGetRequest request = new ItemsListGetRequest();
		request.setFields(FULL_INFO_FIELDS);
		request.setNumIids(numIids);
		
		return taobaoClient.execute(request, session).getItems();
	}
}
