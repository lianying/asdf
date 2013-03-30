package com.thinkgem.jeesite.modules.top.service.topapi.exception;



/**
 * <p>Taobao API 业务逻辑异常。</p>
 * 
 * 参考：<br/>
 * 1.各个Taobao API文档的异常说明<br/>
 * 2.<a href="http://goo.gl/l5MBU">错误码一览表</a><br/>
 * 
 * @author Simon Leung
 * @since 0.1
 */
public class TaobaoApiException extends RuntimeException {
    private static final long serialVersionUID = 9046884995244871369L;
    private String errorCode;
    private String errorMessage;
    private String subErrorCode;
    private String subErrorMessage;
    
    public TaobaoApiException(String errorCode, String errorMessage) {
        this(errorCode, errorMessage, null, null);
    }
    
    public TaobaoApiException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(buildMessage(errorCode, errorMessage, subErrorCode, subErrorMessage));
        initFileds(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
    
    public TaobaoApiException(String message, String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        super(message);
        initFileds(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
    
    /**
	 * 构造函数
	 */
	public TaobaoApiException(Throwable cause) {
		super(cause);
	}

	private void initFileds(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.subErrorCode = subErrorCode;
        this.subErrorMessage = subErrorMessage;
    }
    
    private static String buildMessage(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Code: ").append(errorCode);
        if(subErrorCode != null) {
            strBuilder.append("/");
            strBuilder.append(subErrorCode);
        }
        
        strBuilder.append(", Message: ");
        strBuilder.append(errorMessage);
        if(subErrorMessage != null) {
            strBuilder.append("/");
            strBuilder.append(subErrorMessage);
        }
        return strBuilder.toString();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getSubErrorCode() {
        return subErrorCode;
    }

    public String getSubErrorMessage() {
        return subErrorMessage;
    }
}
