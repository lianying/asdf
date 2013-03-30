package com.thinkgem.jeesite.modules.top.service.topapi.exception;


/**
 * 评价异常
 * 
 * @author Simon Leung
 * @since 0.1
 */
public class RatingException extends TaobaoApiException {
    private static final long serialVersionUID = 1L;

    public RatingException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public RatingException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public RatingException(String message, String errorCode, String errorMessage, String subErrorCode,
        String subErrorMessage) {
        super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

}
