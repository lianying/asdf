package com.thinkgem.jeesite.modules.top.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.taobao.api.internal.mapping.ApiField;
import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 * 淘宝商品Entity
 * @author lay
 * @version 2013-03-18
 */
@Entity
@Table(name = "top_prop_img")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropImg extends BaseEntity {
	
	private static final long serialVersionUID = 1L;


	private Long numIid;
	
	/**
	 * 图片创建时间 时间格式：yyyy-MM-dd HH:mm:ss
	 */
	@ApiField("created")
	private Date created;

	/**
	 * 属性图片的id，和商品相对应
	 */
	@Id
	@ApiField("id")
	private Long id;

	/**
	 * 图片放在第几张（多图时可设置）
	 */
	@ApiField("position")
	private Long position;

	/**
	 * 图片所对应的属性组合的字符串
	 */
	@ApiField("properties")
	private String properties;

	/**
	 * 图片链接地址
	 */
	@ApiField("url")
	private String url;

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	@Id
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getPosition() {
		return this.position;
	}
	public void setPosition(Long position) {
		this.position = position;
	}

	public String getProperties() {
		return this.properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "num_iid")
	public Long getNumIid() {
		return numIid;
	}
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}

}


