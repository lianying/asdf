package com.thinkgem.jeesite.modules.top.service.topapi.exception;


public class TradeException extends TaobaoApiException {
    private static final long serialVersionUID = 1L;

    public TradeException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public TradeException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public TradeException(String message, String errorCode, String errorMessage, String subErrorCode,
        String subErrorMessage) {
        super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

}
