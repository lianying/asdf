package com.thinkgem.jeesite.modules.top.service.topapi.exception;

/**
 * 橱窗推荐超过了最大推荐数量异常
 * @author Michael Leung
 * @since 0.1
 */
public class OutOfAllowedShowcaseCountException extends ItemException {
	private static final long serialVersionUID = 1L;

	public OutOfAllowedShowcaseCountException(String message, String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
	        super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
	    }

    public OutOfAllowedShowcaseCountException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public OutOfAllowedShowcaseCountException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

}
