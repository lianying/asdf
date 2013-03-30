package com.thinkgem.jeesite.modules.top.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 * top用户Entity
 * 
 * @author lay
 * @version 2013-03-22
 */
@Entity
@Table(name = "top_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TopUser extends BaseEntity {

	private static final long serialVersionUID = 1L;

	long id;
	String nick;
	String accessToken;
	String refreshToekn;
	String tokenType;
	long expiresIn;
	long w1ExpiresIn;
	long w2ExpiresIn;
	long r1ExpiresIn;
	long r2ExpiresIn;
	long reExpiresIn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToekn() {
		return refreshToekn;
	}

	public void setRefreshToekn(String refreshToekn) {
		this.refreshToekn = refreshToekn;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public long getW1ExpiresIn() {
		return w1ExpiresIn;
	}

	public void setW1ExpiresIn(long w1ExpiresIn) {
		this.w1ExpiresIn = w1ExpiresIn;
	}

	public long getW2ExpiresIn() {
		return w2ExpiresIn;
	}

	public void setW2ExpiresIn(long w2ExpiresIn) {
		this.w2ExpiresIn = w2ExpiresIn;
	}

	public long getR1ExpiresIn() {
		return r1ExpiresIn;
	}

	public void setR1ExpiresIn(long r1ExpiresIn) {
		this.r1ExpiresIn = r1ExpiresIn;
	}

	public long getR2ExpiresIn() {
		return r2ExpiresIn;
	}

	public void setR2ExpiresIn(long r2ExpiresIn) {
		this.r2ExpiresIn = r2ExpiresIn;
	}

	public long getReExpiresIn() {
		return reExpiresIn;
	}

	public void setReExpiresIn(long reExpiresIn) {
		this.reExpiresIn = reExpiresIn;
	}
}
