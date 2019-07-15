package com.xlx.shiro.dao;

import com.xlx.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Set;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User selectUserByUserAccount(@Param("userAccount") String userAccount);

    Set<String> selectPermissionsByUserAccount(@Param("userAccount") String userAccount);

    Set<String> selectRolesByUserAccount(@Param("userAccount") String userAccount);

    int updateLoginDate(@Param("userAccount") String userAccount, @Param("loginDate")Date loginDate);

}