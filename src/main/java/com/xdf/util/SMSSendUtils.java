package com.xdf.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author justin
 * @since 2018年5月17日
 */
public class SMSSendUtils {
    private static Logger logger = Logger.getLogger(SMSSendUtils.class);
    private static final String ADDR = "http://api2.santo.cc/submit?command=MT_REQUEST";
    private static final String HIWIYUID = "HiwiY-ipxmt";
    private static final String HIWIYPWD = "3H1GyIMR";

    private static final String YYUBERUID = "YYuber-ipxmt";
    private static final String YYUBERPWD = "PG6lWkeH";

    public static final int ASCII = 0;
    public static final int ASCII2 = 1;
    public static final int ISO8859_1 = 3;
    public static final int BINARY = 4;
    public static final int UNICODE = 8;
    public static final int GBK = 15;

    public static final String ENC_ASCII = "ASCII";
    public static final String ENC_CP1252 = "Cp1252";
    public static final String ENC_ISO8859_1 = "ISO8859_1";
    public static final String ENC_UTF16_BEM = "UnicodeBig";
    public static final String ENC_UTF16_BE = "UnicodeBigUnmarked";
    public static final String ENC_UTF16_LEM = "UnicodeLittle";
    public static final String ENC_UTF16_LE = "UnicodeLittleUnmarked";
    public static final String ENC_UTF8 = "UTF8";
    public static final String ENC_UTF16 = "UTF-16";
    public static final String ENC_GBK = "GBK";
    public static final String ENC_BINARY = "";
    //private static final String PWD="3m3mn3";

    /**
     * 发送短信
     *
     * @param Mobile 格式为 国家代码+手机号码，如  8613286007887
     * @param Msg
     * @return
     * @throws Exception
     */
    public static int send(String Mobile, String SiteName, String Msg, boolean IsChinese) throws Exception {
        int returnValue = 0;
        String straddr = "";
        if (1 == 1) {
            if (IsChinese) {
                Msg = encodeHexStr(15, Msg);
                straddr = ADDR + "&cpid=" + HIWIYUID + "&cppwd=" + HIWIYPWD + "&da=" + Mobile + "&dc=15&sm=" + Msg;
            } else {
                Msg = encodeHexStr(8, Msg);
                straddr = ADDR + "&cpid=" + HIWIYUID + "&cppwd=" + HIWIYPWD + "&da=" + Mobile + "&dc=8&sm=" + Msg;
            }
        } else {
            if (IsChinese) {
                Msg = encodeHexStr(15, Msg);
                straddr = ADDR + "&cpid=" + YYUBERUID + "&cppwd=" + YYUBERPWD + "&da=" + Mobile + "&dc=15&sm=" + Msg;
            } else {
                Msg = encodeHexStr(8, Msg);
                straddr = ADDR + "&cpid=" + YYUBERUID + "&cppwd=" + YYUBERPWD + "&da=" + Mobile + "&dc=8&sm=" + Msg;
            }
        }
        StringBuffer sb = new StringBuffer(straddr);
        URL url = new URL(sb.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputline = in.readLine();
        System.out.println(inputline);
        return returnValue;
    }

    /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
     * hexStr2ByteArr(String strIn) 互为可逆的转换过程
     *
     * @param arrB 需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     */
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
     * 互为可逆的转换过程
     *
     * @param strIn 需要转换的字符串
     * @return 转换后的byte数组
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     * @author
     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    /**
     * 根据编码值获取字符集名称
     *
     * @param dataCoding
     * @return
     */
    public static String getEncoding(int dataCoding) {
        switch (dataCoding) {
            case 0:
                return SMSSendUtils.ENC_ASCII;
            case 3:
                return SMSSendUtils.ENC_ISO8859_1;
            case 4:
                return SMSSendUtils.ENC_BINARY;
            case 8:
                return SMSSendUtils.ENC_UTF16_BE;
            case 15:
                return SMSSendUtils.ENC_GBK;
            default:
                return null;
        }
    }

    /**
     * 将普通字符串转换成Hex编码字符串
     *
     * @param dataCoding 编码格式，15表示GBK编码，8表示UnicodeBigUnmarked编码，0表示ISO8859-1编码
     * @param realStr    普通字符串
     * @return Hex编码字符串
     */
    public static String encodeHexStr(int dataCoding, String realStr) {
        String hexStr = null;

        if (realStr != null) {
            byte[] data = null;
            try {
                data = realStr.getBytes(getEncoding(dataCoding));

                if (data != null) {
                    hexStr = byteArr2HexStr(data);
                }
            } catch (Exception e) {
                logger.error("字符串转换成Hex编码字符串发生异常！", e);
            }
        }
        return hexStr;
    }

    /**
     * 将Hex编码字符串还原成普通字符串
     *
     * @param dataCoding 反编码格式，15表示GBK编码，8表示UnicodeBigUnmarked编码，0表示ISO8859-1编码
     * @param hexStr     Hex编码字符串
     * @return 普通字符串
     */
    public static String decodeHexStr(int dataCoding, String hexStr) {
        String realStr = null;

        if (hexStr != null) {
            try {
                byte[] data = hexStr2ByteArr(hexStr);
                realStr = new String(data, getEncoding(dataCoding));
            } catch (Exception e) {
                logger.error("Hex编码字符串转换成普通字符串发生异常！", e);
            }
        }
        return realStr;
    }
}