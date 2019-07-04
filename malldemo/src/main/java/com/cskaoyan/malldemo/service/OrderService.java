package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Order;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/24 14:54
 */
public interface OrderService {

  List<Order> selectByUserId(Integer id, int page, Integer userId, String sort, String order);

  long slectCountByUserId(Integer userId);

  List<Order> selectPageByOrderSn(String orderSn, int page, int limit, String sort, String order);

  long slectCountByStatusArray(Short[] orderStatusArray);

  long slectCountByOrderSn(String orderSn);

  List<Order> selectPageByStatusArray(Short[] orderStatusArray, int page, int limit, String sort, String order);

  List<Order> selectPage(int page, int limit, String sort, String order);

  long slectCount();

  Order selectById(int id);
}
