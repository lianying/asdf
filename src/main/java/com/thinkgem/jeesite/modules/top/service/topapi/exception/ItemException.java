package com.thinkgem.jeesite.modules.top.service.topapi.exception;


/**
 * 商品相关业务异常
 * 
 * @author Simon Leung
 * @since 0.1
 */
public class ItemException extends TaobaoApiException {
    private static final long serialVersionUID = 1L;

    public ItemException(String message, String errorCode, String errorMessage, String subErrorCode,
        String subErrorMessage) {
        super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public ItemException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public ItemException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
