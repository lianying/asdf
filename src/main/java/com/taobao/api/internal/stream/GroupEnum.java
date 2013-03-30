package com.taobao.api.internal.stream;

/**
 * @author junmu
 *
 */
public enum GroupEnum {
	GROUP_DEFAULT("1"),GROUP_SECONDARY("2");
	
	final private String groupId;//不同的组之间的消息是隔离，互不干扰的
	
	public String getGroupId() {
		return groupId;
	}
	private GroupEnum(String groupId){
		this.groupId=groupId;
	}
}
