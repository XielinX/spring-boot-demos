package com.xlx.shiro.dao;

import com.xlx.shiro.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Set<String> selectRoleKeyByUserName(@Param("userName") String userName);
    Set<String> selectRolesByUserName(@Param("userName") String userName);
}