package com.xdf.service.impl;

import com.xdf.dao.RoleDao;
import com.xdf.entity.Role;
import com.xdf.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleServiceimpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    private Logger logger=Logger.getLogger(RoleServiceimpl.class);
    @Override
    public List<Role> selectRoleList() {
        List<Role> roles=null;

        return roles;
    }
}
