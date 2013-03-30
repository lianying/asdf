package com.thinkgem.jeesite.modules.top.service.topapi.exception;


/**
 * API调用后端服务出错，首先查看自己的参数是否合法，如果参数没有问题请过一段时间再尝试.
 * 注：一般都是Taobao后台服务有问题
 * 
 * @author Simon Leung
 * @since 0.1
 */
public class RemoteServiceException extends TaobaoApiException {
    
    private static final long serialVersionUID = 3424928071688084218L;

    public RemoteServiceException(String message, String errorCode, String errorMessage, String subErrorCode,
        String subErrorMessage) {
        super(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public RemoteServiceException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }

    public RemoteServiceException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
