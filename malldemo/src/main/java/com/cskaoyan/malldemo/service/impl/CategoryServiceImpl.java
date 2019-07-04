package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Category;
import com.cskaoyan.malldemo.bean.CategoryExample;
import com.cskaoyan.malldemo.mapper.CategoryMapper;
import com.cskaoyan.malldemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/23 16:49
 */
@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  CategoryMapper categoryMapper;
  @Override
  public List<Category> selectAll() {
    return categoryMapper.selectAll();
  }

  @Override
  public List<Category> selectFirstAll() {
    return categoryMapper.selectLevelAll(0);
  }

  @Override
  public int update(Category category) {

    return categoryMapper.updateByPrimaryKey(category);
  }

  @Override
  public int delete(Category category) {
    return categoryMapper.deleteById(category);
  }

  @Override
  public int insert(Category category) {
    return categoryMapper.insert(category);
  }
}
