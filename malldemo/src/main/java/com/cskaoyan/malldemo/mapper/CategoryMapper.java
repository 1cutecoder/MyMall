package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Category;
import com.cskaoyan.malldemo.bean.CategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    Category selectByPid(@Param("id") int id);

    List<Category> selectAll();

    List<Category> selectLevelAll(@Param("level") int level);

    int deleteById(@Param("category") Category category);
}
