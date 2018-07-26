package com.xdf.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;


public class Tools {


    /**
     * 检测字符串是否不为空(null,"","null")
     *
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s) {
        return s != null && !"".equals(s) && !"null".equals(s);
    }

    /**
     * 检测字符串是否为空(null,"","null")
     *
     * @param s
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s) || "null".equals(s);
    }

    /**
     * 字符串转换为字符串数组
     *
     * @param str        字符串
     * @param splitRegex 分隔符
     * @return
     */
    public static String[] str2StrArray(String str, String splitRegex) {
        if (isEmpty(str)) {
            return null;
        }
        return str.split(splitRegex);
    }

    /**
     * 用默认的分隔符(,)将字符串转换为字符串数组
     *
     * @param str 字符串
     * @return
     */
    public static String[] str2StrArray(String str) {
        return str2StrArray(str, ",\\s*");
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
     *
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String date2Str(Date date) {

        return date2Str(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
     *
     * @param date
     * @return
     */
    public static Date str2Date(String date) {
        if (notEmpty(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return new Date();
        } else {
            return null;
        }
    }

    /**
     * 按照参数format的格式，日期转字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } else {
            return "";
        }
    }


    /**
     * 封装的上传图片方法
     *
     * @param request       文件请求
     * @param saveDirectory 保存文件的目录,要求格式为: /文件夹名
     * @return 返回文件实际存储的相对目录 ，存储失败则返回null
     */
    public static String uploadImages(HttpServletRequest request, String saveDirectory) {
        Logger loggerTemp = Logger.getLogger(Tools.class);
        String imagesUrl = null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        // 判断用户的表单提交方式是不是multipart/form-data,这也是我们在form中设置的那个属性的值 是不是……
        if (multipartResolver.isMultipart(request)) {
            // 判断 request 是否有文件上传,即多部分请求
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            // 获取所有上传文件的名称是input标签中的名称
            Iterator<String> iter = multipartRequest.getFileNames();
            String tempFileName = null; // 临时文件名
         /*   String inputName = null;*/
            String hasLogoImg = null;
            while (iter.hasNext()) {
                String name = iter.next();
                MultipartFile file = multipartRequest.getFile(name);

                String fname = file.getName(); // fname是input的name=***
                  /*  inputName = fname;*/ // 用户上传的图片类型
                String myfname = file.getOriginalFilename(); // myfname代表文件名
                String strDateFolder = CommonUtils.GetUploadFilePath();
                String strFolder = saveDirectory + strDateFolder;
                //  String strFileDistName = CommonUtils.GetNewFileName(myfname);
                String strFileDistFilePath = strDateFolder;// + strFileDistName;

                File fileDir = new File(strFolder);
                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }

                hasLogoImg = myfname; // 用户上传的图片名字
                if (!("".equals(hasLogoImg))) { // 判断用户是否有上传图片
                    String fileExt = myfname.substring(
                            myfname.lastIndexOf(".") + 1).toLowerCase();
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
                    String newFileName = df.format(new Date()) + "_"
                            + new Random().nextInt(1000) + "." + fileExt;
                    // 上传文件域,要将文件保存在服务器端
                    ServletContext sc = request.getSession()
                            .getServletContext();

                    //String path = sc.getRealPath(saveDirectory);/*=======/assets/crmimages=======*/
                    File savefile = new File(strFolder + newFileName);

                    // String imgpath = request.getContextPath();
                    //    imgpath += strFileDistFilePath + "/" + newFileName;/* may be don't need newFileName*/
                    if (tempFileName == null) {
                        tempFileName = name;
                    }
                    try {
                        file.transferTo(savefile);
                        imagesUrl = strFileDistFilePath + newFileName;
                    } catch (IllegalStateException | IOException e) {
                        e.printStackTrace();
                        loggerTemp.error("uploadImages method has a error :" + CommonUtils.getStackTrace(e));
                    } catch (Exception e) {
                        e.printStackTrace();
                        loggerTemp.error("uploadImages method has a error :" + CommonUtils.getStackTrace(e));
                    }
                }
            }
        }
        return imagesUrl;
    }

    /**
     * 封装的上传图片方法
     *
     * @param multipartFiles 文件数组
     * @param realPath       保存文件的目录 来自configinfo
     * @param basePath       保存文件的目录 来自configinfo
     * @return 返回文件实际存储的相对目录 ，存储失败则返回null
     */
    public static String uploadMoreImgsAndThumbnails(MultipartFile[] multipartFiles, String realPath, String basePath) throws Exception {
        int flag = 0;
        String imgUrl = null;
        for (int i = 0; i < multipartFiles.length; i++) {
            MultipartFile file = multipartFiles[i];
            String path = CommonUtils.GetUploadFilePath();
            try {
                Map<String, String> urlresult = new FileUploadUtil(file, realPath, basePath, path).uploadProductResult();
                if (flag == 0) {
                    imgUrl = urlresult.get("path");//设置图片路径
                    flag++;
                } else {
                    imgUrl += "," + urlresult.get("path");//设置图片路径
                    flag++;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return imgUrl;
    }

    /**
     * 获取ip地址
     *
     * @param request 请求
     * @return 返回一个ip地址字符串
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 程序中访问WSDL webservice接口
     * @param urlStr 接口地址Url
     * @return String 返回一个String类型的字符串
     */
    public static String getURLContent(String urlStr) throws Exception {
        /** 网络的url地址 */
        URL url = null;
        /** http连接 */
        HttpURLConnection httpConn = null;
        /** 输入流 */
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL(urlStr);
            in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String str = null;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioex) {
                throw ioex;
            }
        }
        String result = sb.toString();
        //System.out.println(result);
        return result;
    }
}
