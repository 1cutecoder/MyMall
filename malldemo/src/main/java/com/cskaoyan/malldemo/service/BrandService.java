package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Brand;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/23 9:04
 */
public interface BrandService {
  List<Brand> selectPage(int page, int limit, String sort, String order);

  long slectCount();

  Brand selectById(int id);

  List<Brand> selectPageLikeName(String name, int page, int limit, String sort, String order);

  int insert(Brand brand);

  int delete(Brand brand);

  int update(Brand brand);
}
