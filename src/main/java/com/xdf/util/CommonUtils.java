package com.xdf.util;


//import com.bali.onbase.web.model.helperclass.LoginBuyerInfo;
//import com.bali.onbase.web.vo.BuyerInfoVo;
import org.apache.commons.lang3.StringUtils;
        import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import sun.misc.BASE64Encoder;

import javax.net.ssl.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.GZIPInputStream;


/**
 * @author justin
 * @since 2018年5月17日
 */
public class CommonUtils {

    public static Userinfo getUser(HttpSession session){
        return  (Userinfo)session.getAttribute("user");
    }

    /**
     * SHA1加密
     *
     * @param decript
     * @return
     */
    public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * MD5加密
     *
     * @param str
     * @return String
     */
    public static String MD5Encrypt(String str) throws Exception {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String encryptStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return encryptStr;
    }

    /**
     * 获取上传文件的路径（按照执法日期来）
     *
     * @return
     */
    public static String GetUploadFilePath() {
        Calendar date = Calendar.getInstance();
        String year = new SimpleDateFormat("yyyy").format(date.getTime());
        String month = new SimpleDateFormat("MM").format(date.getTime());
        String day = new SimpleDateFormat("dd").format(date.getTime());
        String path = File.separator + year + File.separator + month + File.separator + day + File.separator;
        return path;
    }

    /**
     * 获取详细的错误
     *
     * @param e
     * @return
     */
    public static String getStackTrace(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        e.printStackTrace(writer);
        StringBuffer buffer = stringWriter.getBuffer();
        return buffer.toString();
    }


    /**
     * 获取没有后缀的文件名
     *
     * @param strFileName
     * @return
     */
    public static String GetFileNameWithoutSuffix(String strFileName) {
        if (strFileName != null && !"".equals(strFileName)) {
            return strFileName.substring(0, strFileName.lastIndexOf("."));
        } else {
            return "";
        }
    }


    /**
     * 获取文件的后缀名
     *
     * @param strFileName
     * @return
     */
    public static String GetFileNameSuffix(String strFileName) {
        if (strFileName != null && !"".equals(strFileName)) {
            return strFileName.substring(strFileName.lastIndexOf("."));
        } else {
            return "";
        }
    }


    /**
     * 获取配置文件属性
     */
    public static String GetPropertityValue(HttpServletRequest request, String PropertyName) {
        String propertyValue = "";

        Properties pro = new Properties();
        //String realpath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes");
        try {
            //读取配置文件
            InputStream in = CommonUtils.class.getClassLoader().getResourceAsStream("application.properties");//new FileInputStream(realpath + "/application.properties");
            pro.load(in);
        } catch (FileNotFoundException e) {
            propertyValue = "";
        } catch (IOException e) {
            propertyValue = "";
        }

        //通过key获取配置文件
        propertyValue = (pro.getProperty(PropertyName) == null || "".equals(pro.getProperty(PropertyName))) ? "" : pro.getProperty(PropertyName).toString();
        return propertyValue;
    }

//    public static String GetPropertityValue(ConfigInfo configInfo, String PropertyName) {
//        String propertyValue = "";
//
//        Properties pro = new Properties();
//        try {
//            //读取配置文件
//            InputStream in = CommonUtils.class.getClassLoader().getResourceAsStream("application.properties");//new FileInputStream(realpath + "/application.properties");
//            pro.load(in);
//        } catch (FileNotFoundException e) {
//            propertyValue = "";
//        } catch (IOException e) {
//            propertyValue = "";
//        }
//        //通过key获取配置文件
//        propertyValue = (pro.getProperty(PropertyName) == null || "".equals(pro.getProperty(PropertyName))) ? "" : pro.getProperty(PropertyName).toString();
//        return propertyValue;
//    }


    /**
     * 获得Js的版本
     *
     * @param request
     * @return
     */
    public static String getJsVersion(HttpServletRequest request) {
        return CommonUtils.GetPropertityValue(request, "js.version");
    }


    /**
     * 获得Css的版本
     *
     * @param request
     * @return
     */
    public static String getCssVersion(HttpServletRequest request) {
        return CommonUtils.GetPropertityValue(request, "css.version");
    }

    /**
     * 获取国际化的文件
     *
     * @param request
     * @param response
     * @return
     */
    public static Locale GetLocale(HttpServletRequest request, HttpServletResponse response) {
        Locale locale = Locale.getDefault();
        String strCookieLanguage = CookieUtils.getCookie(request, CookieUtils.COOKIE_NAME_LANGUAGE);
        if (null == strCookieLanguage || "".equals(strCookieLanguage)) {
            locale = new Locale("en", "US");
            (new CookieLocaleResolver()).setLocale(request, response, locale);
        } else if ("en".equals(strCookieLanguage.toLowerCase())) {
            locale = new Locale("en", "US");
            (new CookieLocaleResolver()).setLocale(request, response, locale);
        } else if ("cn".equals(strCookieLanguage.toLowerCase())) {
            locale = new Locale("zh", "CN");
            (new CookieLocaleResolver()).setLocale(request, response, locale);
        } else if ("id".equals(strCookieLanguage.toLowerCase())) {
            locale = new Locale("in", "ID");
            (new CookieLocaleResolver()).setLocale(request, response, locale);
        }
        return locale;
    }


    /**
     * 生成日期随机码
     * 年月日时分秒+随机码
     *
     * @param randomNums 随机码的位数(不含日期时间)
     */
    public static String createDateRandom(int randomNums) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYddMMHHmmss");
        return sdf.format(date) + createRandomByUUID(randomNums);

    }

    /**
     * 通过UUID生成随机码
     */
    public static String createRandomByUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 通过UUID生成 指定位数的随机码
     *
     * @param numSize
     * @return String
     */
    public static String createRandomByUUID(int numSize) {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, numSize);
    }


    /**
     * 得到指定数量的UUID，以数组的形式返回
     *
     * @param arrySize 生成几个数组
     * @return String[]  String数组
     */
    public static String[] createRandomUUID(int arrySize) {
        if (arrySize <= 0)
            return null;
        String[] uuidArr = new String[arrySize];

        for (int i = 0; i < uuidArr.length; i++) {
            uuidArr[i] = createRandomByUUID();
        }
        return uuidArr;
    }


    /**
     * 获取登录信息
     *
     * @param request
     * @return
     */
//    private static LoginBuyerInfo GetLoginInfo(HttpServletRequest request) {
//        /*    HttpServletResponse resp = (HttpServletResponse)response;
//        HttpSession cassession = request.getSession();
//        String username = "AA";
//        if (cassession != null) {
//            Object obj = cassession.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
//            if (obj != null) {
//                Assertion assertion = (Assertion)obj;
//                AttributePrincipal p= assertion.getPrincipal();
//                username = p.getName();
//            }  }
//        */
//
//        LoginBuyerInfo info = new LoginBuyerInfo();
//
//        String strCookieValue = CookieUtils.getCookie(request, CookieUtils.COOKIE_NAME_LOGININFO);
//        String strBase64Code = "";
//
//        try {
//            byte[] bytes = Base64Utils.decodeFromString(strCookieValue);
//            strBase64Code = new String(bytes);
//            info = JSON.parseObject(strBase64Code, LoginBuyerInfo.class);
//            if (info != null) {
//                info.setUserName(CommonUtils.decodeUnicode(info.getUserName()));
//            }
//        } catch (Exception ex) {
//            info = null;
//        }
//        return info;
//    }


//    public static LoginBuyerInfo GetLoginInfo(HttpServletRequest request, HttpServletResponse response) {
//        LoginBuyerInfo info = new LoginBuyerInfo();
//        HttpSession cassession = request.getSession();
//        String username = "";
//        //已经通过认证验证了
//
//        String strCookieValue = CookieUtils.getCookie(request, CookieUtils.COOKIE_NAME_LOGININFO);
//        if (strCookieValue != null && !"".equals(strCookieValue)) {
//            String strBase64Code = "";
//            try {
//                byte[] bytes = Base64Utils.decodeFromString(strCookieValue);
//                strBase64Code = new String(bytes);
//                info = JSON.parseObject(strBase64Code, LoginBuyerInfo.class);
//                if (info != null) {
//                    info.setUserName(CommonUtils.decodeUnicode(info.getUserName()));
//
//                }
//            } catch (Exception ex) {
//                info = null;
//            }
//        } else {
//            Object obj = cassession.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
//            if (obj != null) {
//                Assertion assertion = (Assertion) obj;
//                AttributePrincipal p = assertion.getPrincipal();
//                username = p.getName();
//
//                    /*String email = "";
//                    try {
//                        email = String.valueOf(p.getAttributes().get("email"));
//                    } catch (Exception ex) {
//                        email = "";
//                    }*/
//
//                long buyerid = 0L;
//                try {
//                    buyerid = Long.parseLong(String.valueOf(p.getAttributes().get("buyerid")));
//                } catch (Exception ex) {
//                    buyerid = 0;
//                }
//
//
//                String chiesename = "";
//                try {
//                    chiesename = String.valueOf(p.getAttributes().get("chiesename"));
//                } catch (Exception ex) {
//                    chiesename = "";
//                }
//
//                String englishname = "";
//                try {
//                    englishname = String.valueOf(p.getAttributes().get("englishname"));
//                } catch (Exception ex) {
//                    englishname = "";
//                }
//
//
//                String userName = "";
//                try {
//                    userName = CommonUtils.decodeUnicode(URLDecoder.decode(String.valueOf(p.getAttributes().get("username")), "utf-8"));
//                } catch (Exception ex) {
//                    userName = "";
//                }
//
//                String lastname = "";
//                try {
//                    lastname = CommonUtils.decodeUnicode(URLDecoder.decode(String.valueOf(p.getAttributes().get("lastname")), "utf-8"));
//                } catch (Exception ex) {
//                    lastname = "";
//                }
//                    /*
//                    String telephone = "";
//                    try {
//                        telephone = String.valueOf(p.getAttributes().get("telephone"));
//                    } catch (Exception ex) {
//                        telephone = "";
//                    }
//
//                    int status = 0;
//                    try {
//                        status = Integer.parseInt(String.valueOf(p.getAttributes().get("status")));
//                    } catch (Exception ex) {
//                        status = 0;
//                    }*/
//
//                String ip = "";
//                try {
//                    ip = String.valueOf(p.getAttributes().get("ip"));
//                } catch (Exception ex) {
//                    ip = "";
//                }
//
//                String createddate = "";
//                try {
//                    createddate = String.valueOf(p.getAttributes().get("createddate"));
//                } catch (Exception ex) {
//                    createddate = "";
//                }
 /*
                    String headpicture = "";
                    try {
                        headpicture = String.valueOf(p.getAttributes().get("headpicture"));
                    } catch (Exception ex) {
                        headpicture = "";
                    }



                    String gender = "";
                    try {
                        gender = String.valueOf(p.getAttributes().get("gender"));
                    } catch (Exception ex) {
                        gender = "";
                    }

                String nickName = "";
                    try {
                        nickName = URLDecoder.decode(String.valueOf(p.getAttributes().get("nickName")), "utf-8");
                    } catch (Exception ex) {
                        nickName = "";
                    }*/

//                int roleid = 0;
//                try {
//                    roleid = Integer.parseInt(String.valueOf(p.getAttributes().get("roleid")));
//                } catch (Exception ex) {
//                    roleid = 0;
//                }
//                int roletypeid = 0;
//                try {
//                    roletypeid = Integer.parseInt(String.valueOf(p.getAttributes().get("roletypeid")));
//                } catch (Exception ex) {
//                    roletypeid = 0;
//                }
//                String roleLevelrelationship = "";
//                try {
//                    roleLevelrelationship = String.valueOf(p.getAttributes().get("roleLevelrelationship"));
//                } catch (Exception ex) {
//                    roleLevelrelationship = "";
//                }
//                String rights = "";
//                try {
//                    rights = String.valueOf(p.getAttributes().get("rights"));
//                } catch (Exception ex) {
//                    rights = "";
//                }
//
//
//                info.setBuyerId(buyerid);
//                info.setRoleId(roleid);
//                info.setUserName(userName);
//
//                    /*if (usertype == LoginInfo.LOGINFO_USERTYPE_BUYER) {
//                        info.setOwnerId(buyerid);
//                        info.setUserType(LoginInfo.LOGINFO_USERTYPE_BUYER);
//                    } else if (usertype == LoginInfo.LOGINFO_USERTYPE_SELLER) {
//                        info.setOwnerId(sellerid);
//                        info.setUserType(LoginInfo.LOGINFO_USERTYPE_SELLER);
//                    } else if (usertype == LoginInfo.LOGINFO_USERTYPE_MANUFACTURE) {
//                        info.setOwnerId(manufactureid);
//                        info.setUserType(LoginInfo.LOGINFO_USERTYPE_MANUFACTURE);
//                    }
//                    if (headpicture != null && !"".equals(headpicture)) {
//                        info.setHeadpicture(CommonUtils.GetImageUrl(request, headpicture.replace("\\", "/"), CommonUtils.IMAGESIZE_200x200));
//                    } else {
//                        info.setHeadpicture(CommonUtils.GetSiteContentUrl("/asset/images/default/default-user-200X200.png", request));
//                    }
//                    info.setIsadmin(LoginInfo.LOGINFO_ISADMIN_NO);
//                    */
//
//                if (roleid == 0) {
//                    info.setRights("");
//                    info.setRolelevelrelationship("");
//                    info.setRoletypeid(0);
//                } else {
//                    info.setRights(rights);
//                    info.setRolelevelrelationship(roleLevelrelationship);
//                    info.setRoletypeid(roletypeid);
//                }
//
//                    /*if (logo != null && !"".equals(logo)) {
//                        info.setStorelogo(CommonUtils.GetImageUrl(request, logo.replace("\\", "/"), CommonUtils.IMAGESIZE_200x200));
//                    } else {
//                        info.setStorelogo(CommonUtils.GetSiteContentUrl("/asset/images/default/default-user-500X500.png", request));
//                    }*/
//
//                saveLoginCookie(request, response, info);
//                info.setChinesename(chiesename);
//                info.setEnglishname(englishname);
//            } else {
//                info = null;
//            }
//        }
//        // 当前没有通过验证，那么删除本地Cookie
//        //     CookieUtils.addCookie(response, CookieUtils.COOKIE_NAME_LOGININFO, "", "/", -60 * 60 * 24 * 30);
//         /*   if (GetPropertityValue(request, "domain.url").indexOf("localhost") > 0) {// 本地
//                CookieUtils.addCookie(response, CookieUtils.COOKIE_NAME_LOGININFO, "", "/", -60 * 60 * 24 * 30);
//            } else {
//             //   CookieUtils.addCookie(response, CookieUtils.COOKIE_NAME_LOGININFO, "", "/", GetPropertityValue(request, "websitename").equals(ConfigInfo.WEBSITENAME_HIWIY) ? ".ve.life" : ".yyuber.com",  -60 * 60 * 24 * 30); // cookie保存30天
//            }*/
//        //     request.getSession().invalidate();          //set session invalid
//
////            info = null;
////        }
//        return info;
//    }


    /**
     * unicode转换成中文
     *
     * @param theString
     * @return
     */
    public static String decodeUnicode(String theString) {

        char aChar;

        int len = theString.length();

        StringBuffer outBuffer = new StringBuffer(len);

        for (int x = 0; x < len; ) {

            aChar = theString.charAt(x++);

            if (aChar == '\\') {

                aChar = theString.charAt(x++);

                if (aChar == 'u') {

                    // Read the xxxx

                    int value = 0;

                    for (int i = 0; i < 4; i++) {

                        aChar = theString.charAt(x++);

                        switch (aChar) {

                            case '0':

                            case '1':

                            case '2':

                            case '3':

                            case '4':

                            case '5':

                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';

                    else if (aChar == 'n')

                        aChar = '\n';

                    else if (aChar == 'f')

                        aChar = '\f';

                    outBuffer.append(aChar);

                }

            } else

                outBuffer.append(aChar);

        }

        return outBuffer.toString();

    }


//    public static Boolean saveLoginCookie(HttpServletRequest request, HttpServletResponse response, LoginBuyerInfo loginInfo) {
//        Boolean flag = false;// 标志是否成功保存会话信息
//        byte[] buf = null;
//        try {
//            loginInfo.setUserName(CommonUtils.gbEncoding(loginInfo.getUserName()));
//            String strLoginInfoJSON = JSON.toJSONString(loginInfo);
//            byte[] bytes = strLoginInfoJSON.getBytes();
//            String Base64Code = Base64Utils.encodeToString(bytes);
//            CookieUtils.addCookie(response, CookieUtils.COOKIE_NAME_LOGININFO, Base64Code, "/", 60 * 60 * 24 * 30); //cookie保存30天
//            flag = true;
//        } catch (Exception ex) {
//            flag = false;
//        }
//        return flag;
//    }


//    public static Boolean saveLoginInfoToCookie(HttpServletRequest request, HttpServletResponse response, BuyerInfoVo buyerInfoVoAndRole) {
//        //   CookieUtils.addCookie(response, CookieUtils.COOKIE_NAME_LOGININFO, username, "/", 60 * 60 * 24 * 365); // 保存一年的时间
//        boolean saveFlag = false;
//        LoginBuyerInfo loginBuyerInfo = new LoginBuyerInfo();
//        loginBuyerInfo.setBuyerId(buyerInfoVoAndRole.getUserid());
//        loginBuyerInfo.setRoleId(buyerInfoVoAndRole.getRoleid());
//        loginBuyerInfo.setEnglishname(buyerInfoVoAndRole.getEnglishname());
//        loginBuyerInfo.setChinesename(buyerInfoVoAndRole.getChinesename());
//        loginBuyerInfo.setUserName(buyerInfoVoAndRole.getUsername());
//        if (buyerInfoVoAndRole.getBuyerRole() != null && buyerInfoVoAndRole.getRoleid() != null) {
//            loginBuyerInfo.setRolelevelrelationship(buyerInfoVoAndRole.getBuyerRole().getRolelevelrelationship());
//            loginBuyerInfo.setRights(buyerInfoVoAndRole.getBuyerRole().getRights());
//            loginBuyerInfo.setRolename(buyerInfoVoAndRole.getBuyerRole().getRolename());
//            loginBuyerInfo.setRoletypeid(buyerInfoVoAndRole.getBuyerRole().getRoletypeid());
//        }
//        saveFlag = CommonUtils.saveLoginCookie(request, response, loginBuyerInfo);
//        return saveFlag;
//    }

    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        System.out.println("unicodeBytes is: " + unicodeBytes);
        return unicodeBytes;
    }


    /**
     * 清除Cookie里的account信息
     */
    public static void cleanCookiesAccount(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        CookieUtils.addCookie(response, CookieUtils.COOKIE_NAME_LOGININFO, "", "/", -60 * 60 * 24 * 30);
    }

    /**
     * 封装方法: 处理返回的结果
     */
    public static void processAlertMsg(int resultNum, ResourceBundle rb, ResultMsg msg) {
        if (resultNum > 0) {
            msg.setSuccess(true);
            msg.setMsg(rb.getString("onbase.msg.success"));
        } else {
            msg.setSuccess(false);
            msg.setMsg(rb.getString("onbase.msg.faild"));
        }
    }


    /**
     * MD5加密
     */
    public static String getMD5(String source) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
//         md.update(source.getBytes());
        md.update(source.getBytes("UTF-8"));
        byte[] md5Bytes = md.digest();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < md5Bytes.length; i++) {
            int t = md5Bytes[i] & 0xff;
            if (t <= 0xf) {
                res.append("0");
            }
            res.append(Integer.toHexString(t));
        }
        return res.toString();
    }

    /**
     * 加密参数进行构建
     *
     * @param parameterMap
     * @param str
     * @return
     */
    public static String buildParameter(TreeMap<String, Object> parameterMap, String... str) {
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            buffer.append(entry.getKey());
            if (str.length >= 1 && org.apache.commons.lang3.StringUtils.isNotBlank(str[0])) buffer.append(str[0]);
            buffer.append(entry.getValue());
            if (str.length >= 2 && org.apache.commons.lang3.StringUtils.isNotBlank(str[1])) buffer.append(str[1]);
        }
        if (str.length > 1 && org.apache.commons.lang3.StringUtils.isNotBlank(str[1])) {
            buffer.delete(buffer.length() - 1, buffer.length());
        }
        return buffer.toString();
    }

    /**
     * 发送 POST 请求
     *
     * @param url     目标地址
     * @param params  参数集
     * @param hasFile 是否含文件
     * @return 响应结果 [正常内容，异常内容]
     * @throws IOException
     */
    public static String[] post(String url, Map<String, Object> params, boolean hasFile) throws IOException {
        HttpURLConnection conn = connection(url, 5000);
        try {
            {
                StringBuilder buf = new StringBuilder(128);
                request(conn, params, 10000, buf);
            }

            {
                StringBuilder buf = null;
                String[] res = response(conn, buf);
                return res;
            }
        } finally {
            if (conn != null) conn.disconnect();
        }
    }


    /**
     * 获取连接
     *
     * @param url     远程应用地址
     * @param timeout 连接时长
     * @return 连接实例
     * @throws IOException
     */
    private static HttpURLConnection connection(String url, int timeout) throws IOException {
        URL u = new URL(url);
        HttpURLConnection conn = null;
        if ("https".equals(u.getProtocol())) {
            SSLContext ctx = null;
            try {
                ctx = SSLContext.getInstance("TLS");
                ctx.init(new KeyManager[0], new TrustManager[]{new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }

                    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }}, new SecureRandom());
            } catch (Exception e) {
                throw new IOException(e);
            }
            HttpsURLConnection connHttps = (HttpsURLConnection) u.openConnection();
            connHttps.setSSLSocketFactory(ctx.getSocketFactory());
            connHttps.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;// 默认都认证通过
                }
            });
            conn = connHttps;
        } else {
            conn = (HttpURLConnection) u.openConnection();
        }
        conn.setConnectTimeout(timeout);

        return conn;
    }


    /**
     * 发送请求
     *
     * @param conn    连接
     * @param params  参数集
     * @param timeout 超时时长
     * @param buf     请求内容缓存
     * @throws IOException
     */
    private static void request(HttpURLConnection conn, Map<String, Object> params, int timeout, final StringBuilder buf)
            throws IOException {
        OutputStream os = null;
        Writer writer = null;
        FileInputStream stream = null;
        try {
            conn.setRequestMethod("POST");
            conn.setReadTimeout(timeout);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("User-Agent", "Alibaba API Invoker/Java " + System.getProperty("java.version"));
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            os = conn.getOutputStream();

            writer = new OutputStreamWriter(os, Charset.forName("utf8"));
            if (buf != null) {
                buf.append("GET ").append(conn.getURL().getPath()).append(" >> ");
                writer = new BufferedWriter(writer) {
                    public Writer append(char c) throws IOException {
                        buf.append(c);
                        return super.append(c);
                    }

                    public Writer append(CharSequence csq) throws IOException {
                        buf.append(csq);
                        return super.append(csq);
                    }
                };
            }

            if (params != null) {
                int i = 0;
                for (Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext(); it.remove(), i++) {
                    Map.Entry<String, Object> en = it.next();
                    if (i > 0) writer.append('&');
                    writer.append(encode(trim(en.getKey()), "utf8"));
                    writer.append('=');
                    writer.append(encode(trim(en.getValue()), "utf8"));
                }
            }
            writer.flush();
        } finally {
            if (writer != null) writer.close();
            if (os != null) os.close();
            if (stream != null) stream.close();
        }
    }

    /**
     * 转换 URL 参数
     *
     * @param value   参数值
     * @param charset 字符集
     * @return 参数串
     */
    static String encode(String value, String charset) {
        try {
            return URLEncoder.encode(value, charset);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException();
        }
    }


    /**
     * 修剪字符串
     *
     * @param content 字符串
     * @return 修剪后字符串
     */
    public static String trim(Object content) {
        CharSequence cs = content == null ? null : (content instanceof CharSequence) ? (CharSequence) content : String.valueOf(content);
        if (cs == null) return StringUtils.EMPTY;
        int start = 0;
        int end = cs.length() - 1;
        while (start <= end && Character.isWhitespace(cs.charAt(start)))
            start++;
        while (end >= start && Character.isWhitespace(cs.charAt(end)))
            end--;
        return cs.subSequence(start, end + 1).toString();
    }


    /**
     * 读取响应
     *
     * @param conn 连接
     * @param buf  响应缓存
     * @return 响应内容 [正常内容，异常内容]
     * @throws IOException
     */
    private static String[] response(HttpURLConnection conn, StringBuilder buf) throws IOException {
        Charset cs = charset(conn.getContentType());

        Reader reader = null;
        int index = 1;
        InputStream is = conn.getErrorStream();
        if (is == null) {
            is = conn.getInputStream();
            index = 0;
        }

        try {
            if (gzip(conn.getHeaderField("Content-Encoding"))) is = new GZIPInputStream(is);
            reader = new InputStreamReader(is,
                    cs.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT));
            char[] cbuf = new char[128];

            StringBuilder rbuf = new StringBuilder(128);
            if (buf != null) buf.append(conn.getURL().getPath()).append(" << ");
            for (int r = 0; (r = reader.read(cbuf)) > 0; ) {
                rbuf.append(cbuf, 0, r);
                if (buf != null) buf.append(cbuf, 0, r);
            }

            String[] result = new String[2];
            result[index] = rbuf.toString();
            return result;
        } finally {
            if (is != null) is.close();
        }
    }

    /**
     * 获取字符集
     *
     * @param ctype 内容类型
     * @return 字符集
     */
    private static Charset charset(String ctype) {
        Charset charset = Charset.forName("utf8");

        if (!isBlank(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    try {
                        if (pair.length >= 2 && !isBlank(pair[1])) charset = Charset.forName(pair[1].trim());
                        break;
                    } catch (RuntimeException e) {
                    }
                }
            }
        }

        return charset;
    }


    /**
     * 是否压缩
     *
     * @param encodings 类型
     * @return 是、否
     */
    private static boolean gzip(String encodings) {
        return encodings != null && encodings.indexOf("gzip") > -1;
    }


    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * 获取当天的00点日期时间
     */
    public static Date getTodayStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取当天的23点59分日期时间
     */
    public static Date getTodayEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }


    /**
     *  两个时间之间相差距离多少天 
     *     @param one 时间参数 1： 
     *      @param two 时间参数 2： 
     *      @return 相差天数 
     *  
     */
    public long getDistanceDays(Date one, Date two) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long days = 0;
        try {
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60 * 24);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 清除Cookie里与Session里的账户信息
     */
    public static void clearAccountInfoInCookiesAndSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        CookieUtils.addCookie(response, CookieUtils.COOKIE_NAME_LOGININFO, "", "/", -60 * 60 * 24 * 30);
    }
}