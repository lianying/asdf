package com.thinkgem.jeesite.modules.top.service.topapi.exception;

/**
 * 已评价或已过评价有效期异常
 * @author Michael Leung
 * @since 0.1
 */
public class TradeRatingValidityExpiryException extends RatingException {
	private static final long serialVersionUID = 1L;
	
	public TradeRatingValidityExpiryException(String message, String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

	public TradeRatingValidityExpiryException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
	    super(errorCode, errorMessage, subErrorCode, subErrorMessage);
	}
	
	public TradeRatingValidityExpiryException(String errorCode, String errorMessage) {
	    super(errorCode, errorMessage);
	}
}
