package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Footprint;
import com.cskaoyan.malldemo.bean.FootprintExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootprintMapper {
    long countByExample(FootprintExample example);

    int deleteByExample(FootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    List<Footprint> selectByExample(FootprintExample example);

    Footprint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByExample(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    List<Footprint> selectFootprintList(@Param("startPage") int startPage,@Param("endPage") int endPage,@Param("userId") String userId,@Param("goodsId") String goodsId, @Param("sort") String sort,@Param("order") String order);
}

