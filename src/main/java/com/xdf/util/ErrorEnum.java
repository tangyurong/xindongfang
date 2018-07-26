package com.xdf.util;

import java.util.HashMap;
import java.util.Map;
/**
 * 错误枚举类
 * @author justin
 * @since 2018年5月17日
 *
 */
public enum ErrorEnum {
	/**
	 * 执行成功
	 */
	ERR_000000("000000","执行成功","SUCCEED"),
	/**
	 * 商品订单号为空
	 */
	ERR_100001("100001","商品订单号为空","Goods order is empty"),
	/**
	 * 产品号为空
	 */
	ERR_100002("100002","产品号为空","The product id is empty"),
	/**
	 * 产品名称为空
	 */
	ERR_100003("100003","产品名称为空","The prouct name is empty"),
	/**
	 * 产品描述为空
	 */
	ERR_100004("100004","产品描述为空","The product description is empty"),
	/**
	 * 产品详情为空
	 */
	ERR_100005("100005","产品详情为空","The product particulars is empty"),
	/**
	 * 货币类型为空
	 */
	ERR_100006("100006","货币类型为空","Currency type is empty"),
	/**
	 * 货币类型不支持
	 */
	ERR_100007("100007","货币类型不支持","Currency type does not support"),
	/**
	 * 订单金额为空
	 */
	ERR_100008("100008","订单金额为空","The order amount is empty"),
	/**
	 * 订单金额格式错误
	 */
	ERR_100009("100009","订单金额格式错误","Incorrect order amount format"),
	/**
	 * 买家为空
	 */
	ERR_100010("100010","买家为空","Buyer id is empty"),
	/**
	 * 卖家为空
	 */
	ERR_100011("100011","卖家为空","Seller id is empty"),
	/**
	 * 生产商为空
	 */
	ERR_100012("100012","生产商为空","Productor id is empty"),
	/**
	 * 支付渠道为空
	 */
	ERR_100013("100013","支付渠道为空","The payment channel is empty"),
	/**
	 * 物流渠道为空
	 */
	ERR_100014("100014","物流渠道为空","The logistics channel is empty"),
	/**
	 * 买家不存在
	 */
	ERR_100015("100015","买家不存在","Buyer id does not exit"),
	/**
	 * 卖家不存在
	 */
	ERR_100016("100016","卖家不存在","Seller id does not exit"),
	/**
	 * 生产商不存在
	 */
	ERR_100017("100017","生产商不存在","Productor id does not exit"),
	/**
	 * 支付渠道不存在
	 */
	ERR_100018("100018","支付渠道不存在","The payment channel does not exit"),
	/**
	 * 物流渠道不存在
	 */
	ERR_100019("100019","物流渠道不存在","The logistics channel does not exit"),
	/**
	 * 买家iP地址为空
	 */
	ERR_100020("100020","买家iP地址为空","Buyer IP address is empty"),
	/**
	 * 物流收费为空
	 */
	ERR_100021("100021","物流收费为空","The logistics fee is empty"),
	/**
	 * 订单号为空
	 */
	ERR_100022("100022","订单号为空","Order id is empty"),
	/**
	 * 订单不存在
	 */
	ERR_100023("100023","订单不存在","Order does not exit"),
	/**
	 * 微信生成扫码失败
	 */
	ERR_100024("100024","微信生成扫码失败","WeChatPay FAIL"),
	/**
	 * 查询微信订单失败
	 */
	ERR_100025("100025","查询微信订单失败","Querying order FAIL"),
	/**
	 * 关闭微信订单失败
	 */
	ERR_100026("100026","关闭微信订单失败","Closing order FAIL"),
	/**
	 * 微信支付未完成
	 */
	ERR_100027("100027","微信支付未完成","Order is paying"),
	/**
	 * 订单号无效
	 */
	ERR_100028("100028","无效订单号","Order id is ineffectiveness"),
	/**
	 * 订单类型为空
	 */
	ERR_100029("100029","订单类型为空","The order type is empty"),
	/**
	 * 退款失败，退款金额超限
	 */
	ERR_100030("100030","退款失败，退款金额超限","Refund failed, the refund amount exceeds limit"),
	/**
	 * 客户信息不存在
	 */
	ERR_100031("100031","客户信息不存在","Customer information does not exist"),
	
	
	/**
	 * 签名验证失败
	 */
	ERR_700001("700001","签名验证失败","Signature verification failed"),
	/**
	 * 传递参数错误
	 */
	ERR_700002("700002","传递参数错误","Pass parameter error"),
	
	
	
	/**
	 * 操作失败，请联系客服
	 */
	ERR_800001("800001","操作失败，请联系客服","Failed operation, please contact customer service"),
	/**
	 * 系统超时，请稍后重试
	 */
	ERR_800002("800002","系统超时，请稍后重试","System timeouts, please try again later"),
	/**
	 * 系统错误，请联系客服
	 */
	ERR_800003("800003","系统错误，请联系客服","System fail, please contact customer service"),
	/**
	 * 订单支付中，请稍等
	 */
	ERR_800004("800004","订单支付中，请稍等","Please wait a moment for the order payment"),
	/**
	 * 系统错误
	 */
	ERR_999999("999999","系统错误","FAIL");
	
	private String code;
	private String chMessage;
	private String enMessage;
	
	private ErrorEnum(String code, String chMessage, String enMessage){
		this.code = code;
		this.chMessage = chMessage;
		this.enMessage = enMessage;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getChMessage() {
		return chMessage;
	}
	public void setChMessage(String chMessage) {
		this.chMessage = chMessage;
	}
	public String getEnMessage() {
		return enMessage;
	}
	public void setEnMessage(String enMessage) {
		this.enMessage = enMessage;
	}
	
	/**
	 * 根据code生成map，若找不到code相应枚举，则默认以系统错误返回
	 * @param e
	 * @return
	 */
	public static Map<String, Object> getFailMapByCode(String code){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = true;
		for(ErrorEnum errorEnum:ErrorEnum.values()){
			if(errorEnum.code.equals(code)){
				map.put("code", errorEnum.code);
				map.put("chMessage", errorEnum.chMessage);
				map.put("enMessage", errorEnum.enMessage);
				flag = false;
			}
		}
		if(flag){
			map.put("code", ErrorEnum.ERR_999999.code);
			map.put("chMessage", ErrorEnum.ERR_999999.chMessage);
			map.put("enMessage", ErrorEnum.ERR_999999.enMessage);
		}
		return map;
		
	}
	/**
	 * 根据code生成map，若找不到code相应枚举，则默认以系统错误返回
	 * @param e
	 * @return
	 */
	public static Map<String, String> getStringFailMapByCode(String code){
		Map<String, String> map = new HashMap<String, String>();
		boolean flag = true;
		for(ErrorEnum errorEnum:ErrorEnum.values()){
			if(errorEnum.code.equals(code)){
				map.put("code", errorEnum.code);
				map.put("chMessage", errorEnum.chMessage);
				map.put("enMessage", errorEnum.enMessage);
				flag = false;
			}
		}
		if(flag){
			map.put("code", ErrorEnum.ERR_999999.code);
			map.put("chMessage", ErrorEnum.ERR_999999.chMessage);
			map.put("enMessage", ErrorEnum.ERR_999999.enMessage);
		}
		return map;
		
	}
	
	/**
	 * 根据枚举类型生成map
	 * @param e
	 * @return
	 */
	public static Map<String, Object> getFailMap(ErrorEnum e){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", e.code);
		map.put("chMessage", e.chMessage);
		map.put("enMessage", e.enMessage);
		return map;
	}
	/**
	 * 根据枚举类型生成map
	 * @param e
	 * @return
	 */
	public static Map<String, String> getStringFailMap(ErrorEnum e){
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", e.code);
		map.put("chMessage", e.chMessage);
		map.put("enMessage", e.enMessage);
		return map;
	}
	/**
	 * 根据map生成调用成功map
	 * @param map
	 * @return
	 */
	public static Map<String, Object> getSucceedMap(Map<String, Object> map){
		map.put("code", ErrorEnum.ERR_000000.getCode());
		map.put("chMessage", ErrorEnum.ERR_000000.getChMessage());
		map.put("enMessage", ErrorEnum.ERR_000000.getEnMessage());
		return map;
	}
	/**
	 * 根据map生成调用成功map
	 * @param map
	 * @return
	 */
	public static Map<String, String> getStringSucceedMap(Map<String, String> map){
		map.put("code", ErrorEnum.ERR_000000.getCode());
		map.put("chMessage", ErrorEnum.ERR_000000.getChMessage());
		map.put("enMessage", ErrorEnum.ERR_000000.getEnMessage());
		return map;
	}
	
	
	
}
