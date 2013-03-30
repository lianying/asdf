package com.thinkgem.jeesite.modules.top.service.topapi.exception;

public class RemoteServiceUnavailableException extends TaobaoApiException {

	private static final long serialVersionUID = -449493029926801844L;

	public RemoteServiceUnavailableException(String message, String errorCode,
			String errorMessage, String subErrorCode, String subErrorMessage) {
		super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
	}

	public RemoteServiceUnavailableException(String errorCode,
			String errorMessage, String subErrorCode, String subErrorMessage) {
		super(errorCode, errorMessage, subErrorCode, subErrorMessage);
	}

	public RemoteServiceUnavailableException(String errorCode,
			String errorMessage) {
		super(errorCode, errorMessage);
	}
}
