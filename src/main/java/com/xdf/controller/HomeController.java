package com.xdf.controller;

import com.xdf.entity.Userinfo;
import com.xdf.service.impl.RoleServiceimpl;
import com.xdf.service.impl.UserinfoServiceImpl;
import com.xdf.util.MD5Util;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Resource
    private RoleServiceimpl roleServiceimpl;
    @Resource
    private UserinfoServiceImpl userinfoServiceimpl;

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
    @ResponseBody
    @RequestMapping(value = "/dologin")
    public boolean dologin(String id, String username, String password, HttpSession session) {
        String pwd = MD5Util.md5(password);  //加密
        ModelAndView model=null;
        boolean sf = false;
        Userinfo userinfo = userinfoServiceimpl.selectUserInfo(username, pwd);
        if (userinfo != null) {
            session.setAttribute("user", userinfo);
           sf=true;
        }
        return sf;
    }

    /*
   登录页面
    */
    @RequestMapping(value = "/doindex")
    public String index() {
        return "index";
    }

}
