package com.xdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制类
 *
 */
@Controller
public class HtmlController {
    /**
     **欢迎页面
     * @return
     */
    @RequestMapping("welcome.do")
    public String index(){
        return "welcome";
    }
}
