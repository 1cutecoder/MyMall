package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Brand;
import com.cskaoyan.malldemo.bean.BrandExample;
import com.cskaoyan.malldemo.mapper.BrandMapper;
import com.cskaoyan.malldemo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/23 9:04
 */
@Service
public class BrandServiceImpl implements BrandService {
  @Autowired
  BrandMapper brandMapper;
  @Override
  public List<Brand> selectPage(int page, int limit, String sort, String order) {
    int startIndex=(page-1)*limit;
    int pageSize=limit;
    List<Brand> brands = brandMapper.selectPageBrand(startIndex,pageSize,sort,order);
    return brands;
  }

  @Override
  public long slectCount() {
    return brandMapper.selectCount();
  }

  @Override
  public Brand selectById(int id) {
    return brandMapper.selectByPrimaryKey(id);
  }

  @Override
  public List<Brand> selectPageLikeName(String name, int page, int limit, String sort, String order) {
    int startIndex=(page-1)*limit;
    int pageSize=limit;
    return brandMapper.selectPageLikeName(name,startIndex,pageSize,sort,order);
  }

  @Override
  public int insert(Brand brand) {
    return brandMapper.insertSelective(brand);
  }

  @Override
  public int update(Brand brand) {
    return brandMapper.updateByPrimaryKey(brand);
  }

  @Override
  public int delete(Brand brand) {
    return brandMapper.deleteById(brand);
  }

}

