package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.System;
import com.cskaoyan.malldemo.bean.SystemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemMapper {
    long countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);

    List<String> selectByExample_config(SystemExample example);

    int update_mallconfig(@Param("name")String name, @Param("address")String address, @Param("phone")String phone, @Param("qq")String qq);

    int update_expressconfig(@Param("freight_min")String freight_min, @Param("freight_value")String freight_value);

    int update_orderconfig(@Param("order_unpaid")String order_unpaid, @Param("order_unconfirm")String order_unconfirm,
                           @Param("order_comment")String order_comment);

    int update_wxconfig(@Param("wx_index_new")String wx_index_new, @Param("wx_index_hot")String wx_index_hot,
                        @Param("wx_index_brand")String wx_index_brand, @Param("wx_index_topic")String wx_index_topic,
                        @Param("wx_catlog_list")String wx_catlog_list, @Param("wx_catlog_goods")String wx_catlog_goods,
                        @Param("wx_share")String wx_share);
}
