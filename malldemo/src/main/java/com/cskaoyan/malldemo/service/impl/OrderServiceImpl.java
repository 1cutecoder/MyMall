package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Order;
import com.cskaoyan.malldemo.bean.OrderExample;
import com.cskaoyan.malldemo.mapper.OrderMapper;
import com.cskaoyan.malldemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/24 14:54
 */
@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  OrderMapper orderMapper;

  @Override
  public List<Order> selectByUserId(Integer id, int page, Integer limit, String sort, String order) {
    int startIndex = (page - 1) * limit;
    int pageSize = limit;
    List<Order> orders = orderMapper.selectPageByUserId(id, startIndex, pageSize, sort, order);
    return orders;
  }

  @Override
  public long slectCountByUserId(Integer userId) {
    OrderExample orderExample = new OrderExample();
    OrderExample.Criteria criteria = orderExample.createCriteria();
    criteria.andUserIdEqualTo(userId);
    long count = orderMapper.countByExample(orderExample);
    return count;
  }

  @Override
  public List<Order> selectPageByOrderSn(String orderSn, int page, int limit, String sort, String order) {
    int startIndex = (page - 1) * limit;
    int pageSize = limit;
    List<Order> orders = orderMapper.selectPageByOrderSn(orderSn, startIndex, pageSize, sort, order);
    return orders;
  }

  @Override
  public long slectCountByStatusArray(Short[] orderStatusArray) {
    OrderExample orderExample = new OrderExample();
    OrderExample.Criteria criteria = orderExample.createCriteria();
    for (Short aShort : orderStatusArray) {
      criteria.andOrderStatusEqualTo(aShort);
    }
    long count = orderMapper.countByExample(orderExample);
    return count;
  }

  @Override
  public long slectCountByOrderSn(String orderSn) {
    OrderExample orderExample = new OrderExample();
    OrderExample.Criteria criteria = orderExample.createCriteria();
    criteria.andOrderSnEqualTo(orderSn);
    long count = orderMapper.countByExample(orderExample);
    return count;
  }

  @Override
  public List<Order> selectPageByStatusArray(Short[] orderStatusArray, int page, int limit, String sort, String order) {
    int startIndex = (page - 1) * limit;
    int pageSize = limit;
    List<Order> orders = orderMapper.selectPageByStatusArray(orderStatusArray, startIndex, pageSize, sort, order);
    return orders;
  }

  @Override
  public List<Order> selectPage(int page, int limit, String sort, String order) {
    int startIndex = (page - 1) * limit;
    int pageSize = limit;
    List<Order> orders = orderMapper.selectPage(startIndex, pageSize, sort, order);
    return orders;
  }

  @Override
  public long slectCount() {
    OrderExample orderExample = new OrderExample();
    OrderExample.Criteria criteria = orderExample.createCriteria();
    long count = orderMapper.countByExample(orderExample);
    return count;
  }

  @Override
  public Order selectById(int id) {
    Order order = orderMapper.selectByPrimaryKey(id);
    return order;
  }
}
