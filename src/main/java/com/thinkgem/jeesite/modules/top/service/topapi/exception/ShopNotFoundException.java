package com.thinkgem.jeesite.modules.top.service.topapi.exception;


public class ShopNotFoundException extends TaobaoApiException {
    private static final long serialVersionUID = 1L;

    public ShopNotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ShopNotFoundException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public ShopNotFoundException(String message, String errorCode, String errorMessage, String subErrorCode,
        String subErrorMessage) {
        super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
}
