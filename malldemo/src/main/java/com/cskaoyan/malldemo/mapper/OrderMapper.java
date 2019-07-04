package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Order;
import com.cskaoyan.malldemo.bean.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
  long countByExample(OrderExample example);

  int deleteByExample(OrderExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(Order record);

  int insertSelective(Order record);

  List<Order> selectByExample(OrderExample example);

  Order selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

  int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

  int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    long count_orders(@Param("i")int i);

    long count_customers(@Param("i")int i);

    long count_order_amount(@Param("i")int i);

    // String name,
    //
    List<Order> selectPageByUserId(@Param("userId") Integer id,
                                   @Param("startIndex") int startIndex,
                                   @Param("pageSize") int pageSize,
                                   @Param("sort") String sort,
                                   @Param("order") String order);

    List<Order> selectPageByOrderSn(@Param("orderSn") String orderSn,
                                    @Param("startIndex") int startIndex,
                                    @Param("pageSize") int pageSize,
                                    @Param("sort") String sort,
                                    @Param("order") String order);

    List<Order> selectPageByStatusArray(@Param("orderStatusArray") Short[] orderStatusArray,
                                        @Param("startIndex") int startIndex,
                                        @Param("pageSize") int pageSize,
                                        @Param("sort") String sort,
                                        @Param("order") String order);

    List<Order> selectPage(@Param("startIndex") int startIndex,
                           @Param("pageSize") int pageSize,
                           @Param("sort") String sort,
                           @Param("order") String order);
}
