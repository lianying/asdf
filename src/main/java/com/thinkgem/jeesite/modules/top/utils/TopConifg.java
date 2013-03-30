/**   
* @Title: TopConifg.java 
* @Package com.thinkgem.jeesite.modules.top.utils 
* @Description: TODO
* @author 10060484
* @date 2013-3-28 上午10:26:01 
* @version V1.0   
*/
package com.thinkgem.jeesite.modules.top.utils;

import com.thinkgem.jeesite.common.utils.PropertiesLoader;

/**
 * @author 10060484
 *
 */
public class TopConifg {

	private static String appKey;
	private static String appSecret;
	private static String redirectUrl;
	private static String oauthCodeUrl;
	private static String oauthTokenUrl;
	private static String serverUrl;
	private static String articleCode;
	
	private static final PropertiesLoader prop;
	static {
		prop = new PropertiesLoader("classpath:/top-config.properties");
		appKey = prop.getProperty("app_key");
		appSecret = prop.getProperty("app_ecret");
		redirectUrl = prop.getProperty("redirect_url");
		oauthCodeUrl = prop.getProperty("oauth_code_url");
		oauthTokenUrl = prop.getProperty("oauth_token_url");
		serverUrl = prop.getProperty("server_url");
		articleCode = prop.getProperty("article_code");
	}
	
	public static String getAppKey() {
		return appKey;
	}
	public static String getAppSecret() {
		return appSecret;
	}
	public static String getRedirectUrl() {
		return redirectUrl;
	}
	public static String getOauthUrl() {
		return oauthTokenUrl;
	}
	public static String getServerUrl() {
		return serverUrl;
	}
	public static String getOauthCodeUrl() {
		return oauthCodeUrl;
	}
	public static String getArticleCode() {
		return articleCode;
	}
}
