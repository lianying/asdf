package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;

import com.taobao.api.TaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.TmallProductSpecGetResponse;
import com.taobao.api.ApiRuleException;
/**
 * TOP API: tmall.product.spec.get request
 * 
 * @author auto create
 * @since 1.0, 2013-03-14 16:30:14
 */
public class TmallProductSpecGetRequest implements TaobaoRequest<TmallProductSpecGetResponse> {

	private TaobaoHashMap udfParams; // add user-defined text parameters
	private Long timestamp;

	/** 
	* 要获取信息的产品规格信息。
	 */
	private Long specId;

	public void setSpecId(Long specId) {
		this.specId = specId;
	}
	public Long getSpecId() {
		return this.specId;
	}
	private Map<String,String> headerMap=new TaobaoHashMap();
	
	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getApiMethodName() {
		return "tmall.product.spec.get";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("spec_id", this.specId);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public void putOtherTextParam(String key, String value) {
		if(this.udfParams == null) {
			this.udfParams = new TaobaoHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Class<TmallProductSpecGetResponse> getResponseClass() {
		return TmallProductSpecGetResponse.class;
	}

	public void check() throws ApiRuleException {
		
		RequestCheckUtils.checkNotEmpty(specId,"specId");
	}
	
	public Map<String,String> getHeaderMap() {
		return headerMap;
	}
}
