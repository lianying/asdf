package com.thinkgem.jeesite.modules.top.service.topapi.exception;

/**
 * 在请求需要用户授权类型的Taobao API时，请求参数中的session缺失或者错误。
 * 
 * @author Simon Leung
 * @since 0.1
 */
public class InvalidSessionException extends TaobaoApiException {
    private static final long serialVersionUID = 1L;

    public InvalidSessionException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

}
