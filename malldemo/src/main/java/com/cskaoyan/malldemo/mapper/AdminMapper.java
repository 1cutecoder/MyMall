package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Admin;
import com.cskaoyan.malldemo.bean.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
  long countByExample(AdminExample example);

  int deleteByExample(AdminExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(Admin record);

  int insertSelective(Admin record);

  List<Admin> selectByExample(AdminExample example);

  Admin selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

  int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

  int updateByPrimaryKeySelective(Admin record);

  int updateByPrimaryKey(Admin record);

  List<Admin> selectByUsername(@Param("username") String username);
}
