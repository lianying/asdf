package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;

import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.appip.get response.
 * 
 * @author auto create
 * @since 1.0, null
 */
public class AppipGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 2333738822343927812L;

	/** 
	 * ISV发起请求服务器IP
	 */
	@ApiField("ip")
	private String ip;

	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIp( ) {
		return this.ip;
	}

}
