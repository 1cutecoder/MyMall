package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Permission;
import com.cskaoyan.malldemo.bean.PermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PermissionMapper {
  long countByExample(PermissionExample example);

  int deleteByExample(PermissionExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(Permission record);

  int insertSelective(Permission record);

  List<Permission> selectByExample(PermissionExample example);

  Permission selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

  int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

  int updateByPrimaryKeySelective(Permission record);

  int updateByPrimaryKey(Permission record);

  Set<String> queryByRoleIds(@Param("roleIds") Integer[] roleIds);
}
