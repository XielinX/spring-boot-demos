package com.xlx.shiro.dao;

import com.xlx.shiro.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long resourceId);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long resourceId);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    Set<String> selectPermissionsByUserName(@Param("userName") String userName);
}