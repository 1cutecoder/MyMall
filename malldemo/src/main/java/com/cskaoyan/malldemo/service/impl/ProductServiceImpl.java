package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.GoodsProductExample;
import com.cskaoyan.malldemo.mapper.GoodsProductMapper;
import com.cskaoyan.malldemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cute coder
 * 2019/5/25 21:34
 */
@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  GoodsProductMapper goodsProductMapper;

  @Override
  public long slectCount() {
    GoodsProductExample goodsProductExample = new GoodsProductExample();
    GoodsProductExample.Criteria criteria = goodsProductExample.createCriteria();
    criteria.andNumberGreaterThan(0);
    long count = goodsProductMapper.countByExample(goodsProductExample);
    return count;
  }
}
