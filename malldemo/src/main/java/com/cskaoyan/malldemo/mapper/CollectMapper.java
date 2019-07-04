package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Collect;
import com.cskaoyan.malldemo.bean.CollectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<Collect> selectCollectList(@Param("startPage") int startPage,@Param("endPage") int endPage,@Param("userId") String userId,@Param("valueId") String valueId,@Param("sort") String sort,@Param("order") String order);
}
