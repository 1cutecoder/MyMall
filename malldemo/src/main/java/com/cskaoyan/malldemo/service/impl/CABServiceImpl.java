package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Brand;
import com.cskaoyan.malldemo.bean.BrandExample;
import com.cskaoyan.malldemo.bean.Category;
import com.cskaoyan.malldemo.bean.CategoryExample;
import com.cskaoyan.malldemo.mapper.BrandMapper;
import com.cskaoyan.malldemo.mapper.CategoryMapper;
import com.cskaoyan.malldemo.service.CABService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CABServiceImpl implements CABService {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    BrandMapper brandMapper;

    @Override
    public int insert(Category category, Brand brand) {
        int insertB = brandMapper.insertSelective(brand);
        int insertC = categoryMapper.insert(category);
        return (insertB & insertC);
    }

    @Override
    public List<Category> selectAllCategories() {
        return categoryMapper.selectAll();
    }

    @Override
    public List<Brand> selectBrandVL() {
        BrandExample brandExample = new BrandExample();
        List<Brand> brandList = brandMapper.selectByExample(brandExample);
        return brandList;
    }

    @Override
    public List<Category> selectCategoryVLC() {
        CategoryExample categoryExample = new CategoryExample();
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        return categoryList;
    }
}
