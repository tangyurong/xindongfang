package com.xdf.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author justin
 * @since 2018年5月17日
 */
public class SpiderUtils {

    private static Logger logger = Logger.getLogger(SpiderUtils.class);
    /**
     * 抓取一个页面的内容
     * @param strUrl
     * @return
     */
    public static String GetPageSourceCode(String strUrl){
        String strSourceCode = "";
        try {
            Thread.sleep(5000);

            StringBuilder responseBuilder = null;
            BufferedReader reader = null;
            OutputStreamWriter wr = null;
            URL url;
            try {
                url = new URL(strUrl);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                conn.setRequestProperty("Accept-Encoding","gzip, deflate, sdch");
                conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
                conn.setRequestProperty("Cache-Control","max-age=0");
                conn.setRequestProperty("Connection","keep-alive");
                conn.setRequestProperty("Host","www.aliexpress.com");
                conn.setRequestProperty("Upgrade-Insecure-Requests","1");
                conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
                conn.setDoOutput(true);
                conn.setConnectTimeout(1000 * 5);
                wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write("");
                wr.flush();
                // Get the response
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                logger.error("当前访问链接的状态码："+conn.getResponseCode());
                if(conn.getResponseCode()==302) {
                    String location = conn.getHeaderField("Location");
                    logger.error("当前访问重定向地址："+location);
                }
                responseBuilder = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                wr.close();
                reader.close();
                strSourceCode =responseBuilder.toString();
                System.out.println(responseBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(CommonUtils.getStackTrace(e));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(CommonUtils.getStackTrace(e));
        }
        System.out.println(strSourceCode);
        return strSourceCode;
    }

    public static String regularGroup(String pattern, String matcher) {
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(matcher);
        if (m.find()) { // 如果读到
            return m.group(1);// 返回捕获的数据
        } else {
            return ""; // 否则返回一个空字符串
        }
    }

    public static List<String[]> regularGroupOther(String pattern, String matcher) {
        List<String[]> list = new ArrayList<String[]>();
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(matcher);
        while (m.find()) { // 如果读到
            String[] strings = new String[m.groupCount()];
            for(int i =0;i<m.groupCount();i++) {
                strings[i]=m.group(i+1);
            }
            list.add(strings);
        }
        return list;
    }
}
