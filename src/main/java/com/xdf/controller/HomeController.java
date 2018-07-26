package com.xdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    /*
    登录页面
     */
    @RequestMapping(value = "/xindongfang")
    public String login() {
        return "login";
    }

    /*
      登录
     */
    @RequestMapping(value = "/dologin")
    public String dologin() {
        return "index";
    }

}
