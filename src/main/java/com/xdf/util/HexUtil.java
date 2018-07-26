package com.xdf.util;

import java.io.UnsupportedEncodingException;

//import com.bali.onbase.core.util.ParamUtil;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author justin
 * @since 2018年5月17日
 * 
 * 对参数进行十六进制编码与解密
 *
 */
public class HexUtil {
	/**
	 * Hex编码.
	 */
	public static String encodeHex(String input) {
		String result = null;
		if(!ParamUtil.isEmpty(input)){
			try {
				result = new String(Hex.encodeHex(input.getBytes("UTF-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

	/**
	 * Hex解码.
	 */
	public static String decodeHex(String input) {
		String result = null;
		if(!ParamUtil.isEmpty(input)){
			try {
				result = new String(Hex.decodeHex(input.toCharArray()));
			} catch (DecoderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
