package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Brand;
import com.cskaoyan.malldemo.bean.Category;

import java.util.List;

public interface CABService {

    int insert(Category category, Brand  brand);

    List<Category> selectAllCategories();

    List<Brand> selectBrandVL();

    List<Category> selectCategoryVLC();

}
