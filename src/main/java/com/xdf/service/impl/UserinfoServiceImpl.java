package com.xdf.service.impl;

import com.xdf.dao.UserInfoDao;
import com.xdf.entity.Userinfo;
import com.xdf.service.UserinfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserinfoServiceImpl implements UserinfoService {
    private Logger logger = Logger.getLogger(UserinfoServiceImpl.class);
    @Resource
    private UserInfoDao userInfoDao;


    @Override
    public Userinfo selectUserInfo(String username, String password) {
        Userinfo userinfo=null;
        try {
            userinfo=userInfoDao.selectUserInfo(username,password);
            logger.info("selectUserInfo doing--------------------------------");
        }catch (Exception e){
            logger.info("selectUserInfo doing--------------------------------"+e.getMessage());
        }
        return userinfo;
    }
}
