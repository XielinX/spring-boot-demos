package com.xlx.shiro.dao;

import com.xlx.shiro.entity.LogLogin;

public interface LogLoginMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogLogin record);

    int insertSelective(LogLogin record);

    LogLogin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogLogin record);

    int updateByPrimaryKey(LogLogin record);
}