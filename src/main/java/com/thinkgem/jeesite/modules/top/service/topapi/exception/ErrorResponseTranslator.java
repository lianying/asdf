package com.thinkgem.jeesite.modules.top.service.topapi.exception;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 错误响应翻译器，用于将Taobao API返回的错误响应翻译成相应的异常并抛出。<br/>
 * 参考：<a href="http://goo.gl/l5MBU">错误码一览表</a>
 * 
 * @author Simon Leung
 * @since 0.1
 * @see TaobaoApiException
 */
public class ErrorResponseTranslator {
    public static void throwException(JsonObject errorJson) {
    	
    	
    	
        JsonObject error = errorJson.getAsJsonObject("error_response");
        String code = getElementAsString(error, "code");
        String message = getElementAsString(error, "msg");
        String subCode = getElementAsString(error, "sub_code");
        String subMessage = getElementAsString(error, "sub_msg");
        throwException(code, message, subCode, subMessage, error);
    }
    
    public static boolean isError(JsonObject json) {
        return json.has("error_response");
    }
    
    private static String getElementAsString(JsonObject jsonObject, String key) {
        JsonElement element = jsonObject.get(key);
        if(element != null) {
            return element.getAsString();
        }
        return null;
    }

    /**
     * 根据Taobao Web Api返回的错误码抛出相应的异常。
     */
    public static void throwException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage, JsonObject errorJson) {
        if("isp.remote-service-timeout".equals(subErrorCode)) {
        	throw new RemoteServiceTimeoutException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        } else if("isp.top-remote-connection-timeout".equals(subErrorCode)) {
            throw new RemoteConnectionTimeoutException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        }else if("isv.trade-not-exist".equals(subErrorCode)) {
            throw new TradeNotFoundException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        } else if ("isv.user-not-exist:invalid-nick".equals(subErrorCode)) {
            throw new UserNotFoundException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        } else if ("isv.shop-service-error:SHOP_IS_NOT_EXIST".equals(subErrorCode)) {
            throw new ShopNotFoundException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        } else if("isv.item-get-service-error:ITEM_NOT_FOUND".equals(subErrorCode) || "isv.item-is-delete:invalid-numIid".equals(subErrorCode)) {
            throw new ItemNotFoundException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        } else if("isv.item-recommend-service-error:ERROR_MORE_THAN_ALLOWED_RECOMMEND_NUM".equals(errorCode)){
        	throw new OutOfAllowedShowcaseCountException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        } else if("isv.rate-service-error:-1020".equals(errorCode)){
        	throw new TradeRatingValidityExpiryException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        } else if("520".equals(errorCode)) {
            throwTradeException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        } else if("530".equals(errorCode)) {
            throwItemException(errorCode, errorMessage, subErrorCode, subErrorMessage, errorJson);
        } else if ("27".equals(errorCode)) {
            InvalidSessionException invalidSessionException = new InvalidSessionException(errorCode, errorMessage, subErrorCode, subErrorMessage);
            throw invalidSessionException;
        }  else if("15".equals(errorCode)) {
            throw new RemoteServiceException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        } 
        //R2验证出错异常
        else if("isv.r2-security-authorize-invalid".equals(subErrorCode)) {
        	throw new InvalidSessionException(errorCode, errorMessage, subErrorCode, subErrorMessage);
        }

        String message = "Unknon API error occured, code: " + errorCode + ",message:" + errorMessage + ",sub code:"
            + subErrorCode + ",sub message:" + subErrorMessage;
        throw new TaobaoApiException(message, errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
    
    /**
     * 抛出与商品相关的异常
     */
    private static void throwItemException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage, JsonObject errorJson) {
        throw new ItemException(errorCode, errorMessage, subErrorCode, subErrorMessage);
    }
    
    /**
     * 抛出与交易相关的异常
     */
    private static void throwTradeException(String errorCode, String errorMessage, String subErrorCode, String subErrorMessage) {
    	if("isp.top-remote-service-unavailable".equals(subErrorCode)){
    		throw new RemoteServiceUnavailableException(errorCode, errorMessage, subErrorCode, subErrorMessage);
    	}else if("isp.remote-service-timeout".equals(subErrorCode)){
    		throw new RemoteServiceTimeoutException(errorCode, errorMessage, subErrorCode, subErrorMessage);
    	}else{
    		throw new TradeException(errorCode, errorMessage, subErrorCode, subErrorMessage);
    	}
    }
}
