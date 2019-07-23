package com.xlx.shiro.dao;

import com.xlx.shiro.entity.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long resourceId);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long resourceId);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}