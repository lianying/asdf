package com.thinkgem.jeesite.modules.top.service.topapi.exception;

/**
 * 连接远程服务超时
 * 
 * @author Simon Leung
 * @since 0.1
 */
public class RemoteServiceTimeoutException extends TaobaoApiException {
	private static final long serialVersionUID = 1L;

	public RemoteServiceTimeoutException(String errorCode, String errorMessage,
			String subErrorCode, String subErrorMessage) {
		super(errorCode, errorMessage, subErrorCode, subErrorMessage);
	}
}
