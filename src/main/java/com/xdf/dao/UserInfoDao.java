package com.xdf.dao;

import com.xdf.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoDao {
    /*
    查询用户--登录
     */
    Userinfo selectUserInfo(@Param("username") String username,@Param("password") String password);

}
