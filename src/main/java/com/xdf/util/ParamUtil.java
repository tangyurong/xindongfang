package com.xdf.util;

import java.util.HashMap;
import java.util.Map;

import com.xdf.util.AESUtil;
import com.xdf.util.HexUtil;
import com.xdf.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;



/**
 * 传输参数加工处理
 * @author justin
 * @since 2018年5月17日
 *
 */
public class ParamUtil {
	private static final Logger log = LoggerFactory.getLogger(ParamUtil.class);
	
	/**
	 * Map<String,Object>参数加密
	 * @param param 需传递参数
	 * @return map 
	 */
	public static Map<String,String> encodeParam(Map<String,Object> param){
		log.info("参数加密加工处理开始。。。");
		//增加随机字符和签名
		getSingner(param);
		String json = JSON.toJSONString(param);
		log.info("param转json：{}",json);
		String enhex = HexUtil.encodeHex(json);
		log.info("json进行十六进制编码：{}",enhex);
		String enAES = AESUtil.AESEncode(enhex).replaceAll("\\r\\n", "");
		log.info("AES加密：{}",enAES);
		log.info("参数加密加工处理结束。。。");
		Map<String,String> map = new HashMap<String,String>();
		map.put("param", enAES);
		return map;
	}
	/**
	 * Map<String,String>参数加密
	 * @param param 需传递参数
	 * @return map 
	 */
	public static Map<String,String> encodeStringParam(Map<String,String> param){
		log.info("参数加密加工处理开始。。。");
		getStringSingner(param);
		String json = JSON.toJSONString(param);
		log.info("param转json：{}",json);
		String enhex = HexUtil.encodeHex(json);
		log.info("json进行十六进制编码：{}",enhex);
		String enAES = AESUtil.AESEncode(enhex).replaceAll("\\r\\n", "");
		log.info("AES加密：{}",enAES);
		log.info("参数加密加工处理结束。。。");
		Map<String,String> map = new HashMap<String,String>();
		map.put("param", enAES);
		return map;
	}
	
	/**
	 * 参数解密
	 * @param param 收到参数
	 * @return map 解密
	 */
	public static Map<String,Object> decodeParam(String param){
		log.info("参数解密处理开始。。。");
		log.info("原加密数据={}",param);
		String deAES = AESUtil.AESDecode(param);
		log.info("解密后数据={}",deAES);
		String deHex = HexUtil.decodeHex(deAES);
		log.info("十六进制反编码={}",deHex);
		Map<String,Object> map = jsonToMap(deHex);
		log.info("参数解密加工处理结束。。。");
		return map;
	}
	
	/**
	 * json转map
	 * 
	 * @param json
	 * @return 
	 */
	public static Map<String,Object>  jsonToMap(String json){
		Map<String,Object> map = JSON.parseObject(json,new TypeReference<Map<String,Object>>(){});
		return map;
	}
	/**
	 * 验证传输合法性
	 * 
	 * @param radom 随机字符
	 * @param signer 签名
	 * @return
	 * 
	 */
	public static boolean paramVerify(String radom,String signer){
		return MD5Util.MD5Encode(radom+ MD5Util.MD5_KEY, null).equals(signer);
	}
	
	/**
	 * 增加随机字符和签名
	 * @param map
	 * @return
	 */
	private static void getSingner(Map<String,Object> map){
		String random = AESUtil.getRandomString(6);
		String signer = MD5Util.MD5Encode(random+ MD5Util.MD5_KEY, null);
		map.put("random", random);
		map.put("signer", signer);
	}
	/**
	 * 增加随机字符和签名
	 * @param map
	 * @return
	 */
	private static void getStringSingner(Map<String,String> map){
		String random = AESUtil.getRandomString(6);
		String signer = MD5Util.MD5Encode(random+ MD5Util.MD5_KEY, null);
		map.put("random", random);
		map.put("signer", signer);
	}
	/**
	 * 签名验证
	 * @param map
	 * @return
	 */
	public static boolean chkSigner(Map<String,Object> map){
		String random = (String) map.get("random");
		String signer = (String) map.get("signer");
		if(isEmpty(random) || isEmpty(signer)){
			log.warn("签名验证失败，存在随机数或签名为空，参数random={},signer={}",random,signer);
			return false;
		}else{
			return signer.equals(MD5Util.MD5Encode(random+ MD5Util.MD5_KEY, null));
		}
	}
	
	/**
	 * 判断字符是否为空
	 * @param str
	 * @return
	 */
    public static boolean isEmpty(String str) {
    	if(null != str){
    		str = str.trim();
    	}
        return null == str || "".equals(str);
    }
	
	
	
	public static void main(String[] args){
		String str = "4FFRWGFc76tnN2XwBZicpVLyLSE1/DX+CyfCefhZ3dJdnphPdMTexHmwH1wShO1Z6D+m/yxTB/zzJgqCH6QXL5rvDW1QFk8BgSFT8CNEIy2Do1JY6OXe1029NIGAjOivjUTe9fCTVrsvJiuYDvzoeEd6rtJLBPg7o90pDcqi3wHxG6TA/3Aek8UvogGlRcCFRbtidE9MPEwycbfGCnZrWsZbEg1HOThcl7GrXV8qat6l/r/iQ+MnoJG/fdaNDo7Irfvtz7Y0Dgom+e8YD1xrMsssVV/yFM+UbxjSz/uEIdOBU0usupVN8UNQdCa5RmdEyODymdtQBKHlJpmONzxmyIev57GQctMIFIeYKsN7+Wrk4ZC4xZrOhFwBi/xgjspk6H7vBcpce1JW1zeVMDgiOdhj6Qbt3cR0vtWs2ayuyrFXbV5Me2E8Oo4IVSpivF6s+EuKmDPtqkAOcs1pJTntMISBa4JetmT9XNii30B3LbSuHIMgQGrQnFtUBj+chVuY0zQUB3Vj6MZmQQF44HGueLv1gPgnJGa9/rVedQuvv3mmUsHcao/TX83KWLi5Qs5WK94LHh9ylTGFYoXJJkMzGMpk+IpymfEAHes5eCpIs5k1uDXwO+/TlM7FzGPe0oeNOfjVxBFvUOWuAJcI7U9yQ5KOVk3tOTHUVAO4K9zIWHf0axPrB4fjWWKl29+958pPtJRXMmdJm66orX/KwfvcyJbD6OUhmn/SwEZATscT2qcccFi7tTrO4MIafN0/9ZU4i/cfHIGVLXG4h3bXVdlqxss7mwary+9R+RsWqj494FEgLU2WM/4v5N7beBv90Ohz9CsLaBC2N3zySmRHsZALcTr0fuQODpdvf8sA1pILj0eLIUgtl94/Il/CU7bgkoiH";
		decodeParam(str);
	}
}
