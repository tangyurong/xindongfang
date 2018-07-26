package com.xdf.util;

import java.util.HashMap;
import java.util.Map;

/**
 *  For a full list of configuration parameters refer in wiki page[https://github.com/paypal/sdk-core-java/blob/master/README.md] 
 */
public class Configuration {
	
	// Creates a configuration map containing credentials and other required configuration parameters.
	public static final Map<String,String> getAcctAndConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		configMap.putAll(getConfig());
				
		// Account Credential


		/*
		configMap.put("acct1.UserName", "87645998003_api1.qq.com");
		configMap.put("acct1.Password", "RGUCGHVPMASATPRH");
		configMap.put("acct1.Signature", "AFcWxV21C7fd0v3bYYYRCpSSRl31AFFXnshyc-P2rK7Pzm6WVZED6EtH");
	    configMap.put("acct1.AppId", "APP-80W284485P519543T");
		*/

		/*
		configMap.put("acct1.UserName", "87645998_api1.qq.com");
		configMap.put("acct1.Password", "4SLGUZS6ZUH2WGWA");
		configMap.put("acct1.Signature", "AFcWxV21C7fd0v3bYYYRCpSSRl31A65RJ4hMxqP4n0Sivbj-302j.LpT");
		configMap.put("acct1.AppId", "APP-80W284485P519543T");
		*/


		configMap.put("acct1.UserName", "cooperation_api1.yyuber.com");
		configMap.put("acct1.Password", "LF65HS9K2RFT599Q");
		configMap.put("acct1.Signature", "AFcWxV21C7fd0v3bYYYRCpSSRl31A.d0-JQ22gFt6Z8ANSWtT6fu07I3");
		configMap.put("acct1.AppId", "APP-88133124UT2840346");


		// Sample Certificate credential
		// configMap.put("acct2.UserName", "certuser_biz_api1.paypal.com");
		// configMap.put("acct2.Password", "D6JNKKULHN3G5B8A");
		// configMap.put("acct2.CertKey", "password");
		// configMap.put("acct2.CertPath", "resource/sdk-cert.p12");
		// configMap.put("acct2.AppId", "APP-80W284485P519543T");
		
		return configMap;
	}
	
	public static final Map<String,String> getConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		
		// Endpoints are varied depending on whether sandbox OR live is chosen for mode

		configMap.put("mode", "live");
		//configMap.put("mode", "sandbox");
		
		// These values are defaulted in SDK. If you want to override default values, uncomment it and add your value.
		// configMap.put("http.ConnectionTimeOut", "5000");
		// configMap.put("http.Retry", "2");
		// configMap.put("http.ReadTimeOut", "30000");
		// configMap.put("http.MaxConnection", "100");
		return configMap;
	}
}
