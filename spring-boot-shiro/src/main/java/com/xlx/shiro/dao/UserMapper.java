package com.xlx.shiro.dao;

import com.xlx.shiro.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User selectUserByUserName(@Param("userName") String userName);

    Set<String> selectPermissionsByUserName(@Param("userName") String userName);

    Set<String> selectRolesByUserName(@Param("userName") String userName);

    int updateLoginDate(@Param("userName") String userName, @Param("loginDate") Date loginDate);

}