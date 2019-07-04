package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Brand;
import com.cskaoyan.malldemo.bean.BrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
  long countByExample(BrandExample example);

  int deleteByExample(BrandExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(Brand record);

  int insertSelective(Brand record);

  List<Brand> selectByExample(BrandExample example);

  Brand selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

  int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

  int updateByPrimaryKeySelective(Brand record);

  int updateByPrimaryKey(Brand record);

  List<Brand> selectPageBrand(@Param("startIndex") int startIndex,
                              @Param("pageSize") int pageSize,
                              @Param("sort") String sort,
                              @Param("order") String order);

  long selectCount();

  List<Brand> selectLikeName(@Param("name") String name);

  List<Brand> selectPageLikeName(@Param("name") String name,
                                 @Param("startIndex") int startIndex,
                                 @Param("pageSize") int pageSize,
                                 @Param("sort") String sort,
                                 @Param("order") String order);

    int deleteById(@Param("brand") Brand brand);
}
