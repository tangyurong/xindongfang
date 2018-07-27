package com.xdf.dao;

import com.xdf.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {
    /*
    查询角色
     */
    List<Role> selectRoleList();

}
