package com.thinkgem.jeesite.modules.top.service.topapi.exception;

/**
 * 
 * 
 * @author Simon Leung
 * @since 0.1
 */
public class RemoteConnectionTimeoutException extends TaobaoApiException {
    private static final long serialVersionUID = 1L;

    public RemoteConnectionTimeoutException(String errorCode, String errorMessage, String subErrorCode,
        String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

}
