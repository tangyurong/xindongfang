package com.xdf.service;

import com.xdf.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserinfoService {
    /*
   查询用户--登录
    */
    Userinfo selectUserInfo(String username, String password);

}
