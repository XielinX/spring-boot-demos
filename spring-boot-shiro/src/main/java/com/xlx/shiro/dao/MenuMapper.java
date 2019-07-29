package com.xlx.shiro.dao;

import com.xlx.shiro.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface MenuMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);



    Set<String> selectPermissionsByUserName(@Param("userName") String userName);

    List<Menu> selectMenusByUserName(@Param("userName") String userName);
}