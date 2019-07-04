package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Goods;
import com.cskaoyan.malldemo.bean.GoodsAttribute;
import com.cskaoyan.malldemo.bean.GoodsProduct;
import com.cskaoyan.malldemo.bean.GoodsSpecification;

import java.util.HashMap;
import java.util.List;

public interface GoodsService {
    List<Goods> findAllGoods(int page, int limit, Goods goods);

    long selectCount();

    int deleteGoods(Goods goods);

    int insertGoods(Goods goods);

    int insertAll(GoodsAttribute goodsAttribute, GoodsProduct goodsProduct, GoodsSpecification goodsSpecification);

    HashMap<String,Object> selectDetail(Integer goodsId);

}
