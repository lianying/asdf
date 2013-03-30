package com.taobao.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.HashMap;
import java.util.Map;

import com.taobao.api.FileItem;
import com.taobao.api.TaobaoUploadRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.TmallProductSpecAddResponse;
import com.taobao.api.ApiRuleException;
/**
 * TOP API: tmall.product.spec.add request
 * 
 * @author auto create
 * @since 1.0, 2013-03-14 16:30:14
 */
public class TmallProductSpecAddRequest implements TaobaoUploadRequest<TmallProductSpecAddResponse> {

	private TaobaoHashMap udfParams; // add user-defined text parameters
	private Long timestamp;

	/** 
	* 产品二维码
	 */
	private String barcode;

	/** 
	* 存放产品规格认证类型-认证图片url映射信息，格式为k:v;k:v;，其中key为认证类型数字id，value为调用tmall.product.spec.pic.upload返回的认证图片url文本
	 */
	private String certifiedPicStr;

	/** 
	* 产品图片
	 */
	private FileItem image;

	/** 
	* 产品ID
	 */
	private Long productId;

	/** 
	* 产品的规格属性
	 */
	private String specProps;

	/** 
	* 规格属性别名
	 */
	private String specPropsAlias;

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getBarcode() {
		return this.barcode;
	}

	public void setCertifiedPicStr(String certifiedPicStr) {
		this.certifiedPicStr = certifiedPicStr;
	}
	public String getCertifiedPicStr() {
		return this.certifiedPicStr;
	}

	public void setImage(FileItem image) {
		this.image = image;
	}
	public FileItem getImage() {
		return this.image;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getProductId() {
		return this.productId;
	}

	public void setSpecProps(String specProps) {
		this.specProps = specProps;
	}
	public String getSpecProps() {
		return this.specProps;
	}

	public void setSpecPropsAlias(String specPropsAlias) {
		this.specPropsAlias = specPropsAlias;
	}
	public String getSpecPropsAlias() {
		return this.specPropsAlias;
	}
	private Map<String,String> headerMap=new TaobaoHashMap();
	
	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getApiMethodName() {
		return "tmall.product.spec.add";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("barcode", this.barcode);
		txtParams.put("certified_pic_str", this.certifiedPicStr);
		txtParams.put("product_id", this.productId);
		txtParams.put("spec_props", this.specProps);
		txtParams.put("spec_props_alias", this.specPropsAlias);
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
		params.put("image", this.image);
		return params;
	}

	public Class<TmallProductSpecAddResponse> getResponseClass() {
		return TmallProductSpecAddResponse.class;
	}

	public void check() throws ApiRuleException {
		
		RequestCheckUtils.checkNotEmpty(barcode,"barcode");
		RequestCheckUtils.checkNotEmpty(image,"image");
		RequestCheckUtils.checkNotEmpty(productId,"productId");
		RequestCheckUtils.checkNotEmpty(specProps,"specProps");
		RequestCheckUtils.checkMaxLength(specPropsAlias,60,"specPropsAlias");
	}
	
	public Map<String,String> getHeaderMap() {
		return headerMap;
	}
}
