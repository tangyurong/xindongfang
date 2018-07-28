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
     **领导欢迎页面
     * @return
     */
    @RequestMapping("ld/welcome.do")
    public String welcome(){
        return "administration/welcome";
    }

    /**
     **公司管理页面
     * @return
     */
    @RequestMapping("ld/management.do")
    public String management(){
        return "administration/management";
    }

    /**
     **t添加公司管理页面
     * @return
     */
    @RequestMapping("ld/addmanagement.do")
    public String addmanagement(){
        return "administration/management-add";
    }

    /**
     * 领导首页
     * @return
     */
    @RequestMapping("AdminIndex.do")
    public String AdminIndex(){
        return "administration/index";
    }

}
