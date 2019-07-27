package com.xlx.shiro.dao;

import com.xlx.shiro.entity.LogError;

public interface LogErrorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogError record);

    int insertSelective(LogError record);

    LogError selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogError record);

    int updateByPrimaryKey(LogError record);
}