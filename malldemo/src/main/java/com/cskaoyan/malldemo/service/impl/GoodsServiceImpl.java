package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.*;
import com.cskaoyan.malldemo.mapper.*;
import com.cskaoyan.malldemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;
    @Autowired
    GoodsSpecificationMapper goodsSpecificationMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Goods> findAllGoods(int page, int limit, Goods goods) {
        int startIndex= (page-1)*limit;
        int pageSize= limit;
        List<Goods> allGoods = goodsMapper.findAllGoods(goods,startIndex, pageSize);
        return allGoods;
    }

    @Override
    public long selectCount() {
        GoodsExample example = new GoodsExample();
        long count = goodsMapper.countByExample(example);
        return count;
    }

    @Override
    public int deleteGoods(Goods Goods) {
        int i = goodsMapper.deleteGoods(Goods);
        return i;
    }

    @Override
    public int insertGoods(Goods goods) {
        int i = goodsMapper.insertGoods(goods);
        return i;
    }

    @Override
    public int insertAll(GoodsAttribute goodsAttribute, GoodsProduct goodsProduct, GoodsSpecification goodsSpecification) {

        int insertGoodsAttribute = goodsAttributeMapper.insertGoodsAttribute(goodsAttribute);
        int insertGoodsProduct = goodsProductMapper.insertGoodsProduct(goodsProduct);
        int insertGoodsSpecification = goodsSpecificationMapper.insertGoodsSpecification(goodsSpecification);
        if(insertGoodsAttribute>=1&&insertGoodsProduct>=1&&insertGoodsSpecification>=1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public HashMap<String, Object> selectDetail(Integer goodsId) {
        HashMap<String, Object> data = new HashMap<>();
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        GoodsAttribute attribute = goodsAttributeMapper.selectByGoodsId(goodsId);
        GoodsProduct product = goodsProductMapper.selectByGoodsId(goodsId);
        GoodsSpecification goodsSpecification = goodsSpecificationMapper.selectByGoodsId(goodsId);


        Integer categoryId = goods.getCategoryId();
        if(categoryId != null) {
            Category category = categoryMapper.selectByPrimaryKey(categoryId);

            data.put("attributes", attribute);
            data.put("categoryIds", category);
            data.put("goods", goods);
            data.put("products", product);
            data.put("specifications", goodsSpecification);

            return data;
        } else {
            return null;
        }
    }
}
