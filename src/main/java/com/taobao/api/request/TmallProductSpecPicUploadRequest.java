package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.HashMap;
import java.util.Map;

import com.taobao.api.FileItem;
import com.taobao.api.TaobaoUploadRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.TmallProductSpecPicUploadResponse;
import com.taobao.api.ApiRuleException;
/**
 * TOP API: tmall.product.spec.pic.upload request
 * 
 * @author auto create
 * @since 1.0, 2013-03-14 16:30:14
 */
public class TmallProductSpecPicUploadRequest implements TaobaoUploadRequest<TmallProductSpecPicUploadResponse> {

	private TaobaoHashMap udfParams; // add user-defined text parameters
	private Long timestamp;

	/** 
	* 上传的认证图片文件
	 */
	private FileItem certifyPic;

	/** 
	* 上传的认证图片的认证类型
	 */
	private Long certifyType;

	public void setCertifyPic(FileItem certifyPic) {
		this.certifyPic = certifyPic;
	}
	public FileItem getCertifyPic() {
		return this.certifyPic;
	}

	public void setCertifyType(Long certifyType) {
		this.certifyType = certifyType;
	}
	public Long getCertifyType() {
		return this.certifyType;
	}
	private Map<String,String> headerMap=new TaobaoHashMap();
	
	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getApiMethodName() {
		return "tmall.product.spec.pic.upload";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("certify_type", this.certifyType);
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

	public Map<String, FileItem> getFileParams() {
		Map<String, FileItem> params = new HashMap<String, FileItem>();
		params.put("certify_pic", this.certifyPic);
		return params;
	}

	public Class<TmallProductSpecPicUploadResponse> getResponseClass() {
		return TmallProductSpecPicUploadResponse.class;
	}

	public void check() throws ApiRuleException {
		
		RequestCheckUtils.checkNotEmpty(certifyPic,"certifyPic");
		RequestCheckUtils.checkNotEmpty(certifyType,"certifyType");
	}
	
	public Map<String,String> getHeaderMap() {
		return headerMap;
	}
}
