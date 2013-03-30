package com.thinkgem.jeesite.modules.top.service.topapi.exception;


public class TradeNotFoundException extends RemoteServiceException {
    private static final long serialVersionUID = 1L;

    public TradeNotFoundException(String message, String errorCode, String errorMessage, String subErrorCode,
        String subErrorMessage) {
        super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public TradeNotFoundException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public TradeNotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
