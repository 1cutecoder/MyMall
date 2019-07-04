package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Address;
import com.cskaoyan.malldemo.bean.AddressExample;
import com.cskaoyan.malldemo.bean.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectAddressList(@Param("startPage") int startPage,@Param("endPage") int endPage,@Param("sort") String sort, @Param("name") String name, @Param("order") String order,@Param("userId") String userId);
}
