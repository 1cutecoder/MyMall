package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Order;
import com.cskaoyan.malldemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by cute coder
 * 2019/5/23 9:04
 */
@Controller
@RequestMapping("order")
public class OrderController {

  @Autowired
  OrderService orderService;

  @RequestMapping("list")
  @ResponseBody
  public Map list(int page, int limit, String sort, String order, Integer userId, String orderSn, Short[] orderStatusArray) {
    HashMap<String, Object> vo = new HashMap<>();
    HashMap<String, Object> data = new HashMap<>();
    List<Order> orders = new LinkedList<>();
    long total=0;
    if (userId != null && userId != 0) {
      orders = orderService.selectByUserId(userId, page, limit, sort, order);
      total =orderService.slectCountByUserId(userId);
    } else if (orderSn != null && orderStatusArray==null) {
      orders = orderService.selectPageByOrderSn(orderSn, page, limit, sort, order);
      total =orderService.slectCountByOrderSn(orderSn);
    } else if (orderSn == null && orderStatusArray!=null){
      orders = orderService.selectPageByStatusArray(orderStatusArray,page, limit, sort, order);
      total = orderService.slectCountByStatusArray(orderStatusArray);
    } else {
      orders = orderService.selectPage(page, limit, sort, order);
      total = orderService.slectCount();
    }
    data.put("total", total);
    data.put("items", orders);
    vo.put("data", data);
    vo.put("errno", 0);
    vo.put("errmsg", "成功");
    return vo;
  }

  @RequestMapping("detail")
  @ResponseBody
  public Map detail(int id){
    HashMap<String, Object> vo = new HashMap<>();
    HashMap<String, Object> data = new HashMap<>();
    Order order = orderService.selectById(id);
    data.put("user", order.getUser());
    data.put("orderGoods",order.getOrderGoods());
    order.setUser(null);
    order.setOrderGoods(null);
    data.put("order", order);
    vo.put("data", data);
    vo.put("errno", 0);
    vo.put("errmsg", "成功");
    return vo;
  }


}
