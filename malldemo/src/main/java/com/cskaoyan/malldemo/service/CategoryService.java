package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Category;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/23 16:49
 */
public interface CategoryService {
    List<Category> selectAll();

    List<Category> selectFirstAll();

    int update(Category category);

    int delete(Category category);

    int insert(Category category);
}
