package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.GoodsSpecification;
import com.cskaoyan.malldemo.bean.GoodsSpecificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSpecificationMapper {
    long countByExample(GoodsSpecificationExample example);

    int deleteByExample(GoodsSpecificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSpecification record);

    int insertSelective(GoodsSpecification record);

    List<GoodsSpecification> selectByExample(GoodsSpecificationExample example);

    GoodsSpecification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsSpecification record, @Param("example") GoodsSpecificationExample example);

    int updateByExample(@Param("record") GoodsSpecification record, @Param("example") GoodsSpecificationExample example);

    int updateByPrimaryKeySelective(GoodsSpecification record);

    int updateByPrimaryKey(GoodsSpecification record);

    int insertGoodsSpecification(@Param("spec") GoodsSpecification record);

    GoodsSpecification selectByGoodsId(Integer goodsId);

}
