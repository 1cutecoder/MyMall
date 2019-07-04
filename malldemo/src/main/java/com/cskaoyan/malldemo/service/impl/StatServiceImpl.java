package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.mapper.OrderGoodsMapper;
import com.cskaoyan.malldemo.mapper.OrderMapper;
import com.cskaoyan.malldemo.mapper.UserMapper;
import com.cskaoyan.malldemo.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StatServiceImpl implements StatService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Override
    public Map<String, Object> select_user() {
        int[] i = new int[7];
        boolean flag = true;
        for (int j = 0; j <7; j++) {
             i[j] = (int)userMapper.count_users(j);
             if(i[j] < 0){
                 flag = false;
                 break;
             }
        }

        if(flag){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,0);
            String day1 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day2 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day3 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day4 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day5 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day6 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day7 = df.format(calendar.getTime());

            List<String> columns = new LinkedList<>();
            columns.add("day");
            columns.add("users");

            List<Map> rows = new LinkedList<>();
            Map<String, Object> rows_map1 = new HashMap<>();
            rows_map1.put("day",day1);
            rows_map1.put("users",i[0]);
            Map<String, Object> rows_map2 = new HashMap<>();
            rows_map2.put("day",day2);
            rows_map2.put("users",i[1]);
            Map<String, Object> rows_map3 = new HashMap<>();
            rows_map3.put("day",day3);
            rows_map3.put("users",i[2]);
            Map<String, Object> rows_map4 = new HashMap<>();
            rows_map4.put("day",day4);
            rows_map4.put("users",i[3]);
            Map<String, Object> rows_map5 = new HashMap<>();
            rows_map5.put("day",day5);
            rows_map5.put("users",i[4]);
            Map<String, Object> rows_map6 = new HashMap<>();
            rows_map6.put("day",day6);
            rows_map6.put("users",i[5]);
            Map<String, Object> rows_map7 = new HashMap<>();
            rows_map7.put("day",day7);
            rows_map7.put("users",i[6]);
            rows.add(rows_map1);
            rows.add(rows_map2);
            rows.add(rows_map3);
            rows.add(rows_map4);
            rows.add(rows_map5);
            rows.add(rows_map6);
            rows.add(rows_map7);

            Map<String, Object> map = new HashMap<>();
            map.put("columns",columns);
            map.put("rows",rows);

            return map;
        }
        return null;
    }

    @Override
    public Map<String, Object> select_order() {
        int[] orders = new int[7];
        boolean flag1 = true;
        for (int j = 0; j <7; j++) {
            orders[j] = (int)orderMapper.count_orders(j);
            if(orders[j] < 0){
                flag1 = false;
                break;
            }
        }
        int[] customers = new int[7];
        boolean flag2 = true;
        for (int j = 0; j <7; j++) {
            customers[j] = (int)orderMapper.count_customers(j);
            if(customers[j] < 0){
                flag2 = false;
                break;
            }
        }
        float[] amount = new float[7];
        boolean flag3 = true;
        for (int j = 0; j <7; j++) {
            if(orders[j] != 0){
                amount[j] = (float)orderMapper.count_order_amount(j);
            } else {
                amount[j] = 0;
            }

            if(amount[j] < 0){
                flag3 = false;
                break;
            }
        }
        float[] pcr = new float[7];
        for (int j = 0; j <7; j++) {
            pcr[j] = amount[j] / customers[j];
        }

        if(!(flag1&&flag2&&flag3)){
            return null;
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,0);
            String day1 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day2 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day3 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day4 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day5 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day6 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day7 = df.format(calendar.getTime());

            List<String> columns = new LinkedList<>();
            columns.add("day");
            columns.add("orders");
            columns.add("customers");
            columns.add("amount");
            columns.add("pcr");

            List<Map> rows = new LinkedList<>();
            Map<String, Object> rows_map1 = new HashMap<>();
            rows_map1.put("day",day1);
            rows_map1.put("orders",orders[0]);
            rows_map1.put("customers",customers[0]);
            rows_map1.put("amount",amount[0]);
            rows_map1.put("pcr",pcr[0]);
            Map<String, Object> rows_map2 = new HashMap<>();
            rows_map2.put("day",day2);
            rows_map2.put("orders",orders[1]);
            rows_map2.put("customers",customers[1]);
            rows_map2.put("amount",amount[1]);
            rows_map2.put("pcr",pcr[1]);
            Map<String, Object> rows_map3 = new HashMap<>();
            rows_map3.put("day",day3);
            rows_map3.put("orders",orders[2]);
            rows_map3.put("customers",customers[2]);
            rows_map3.put("amount",amount[2]);
            rows_map3.put("pcr",pcr[2]);
            Map<String, Object> rows_map4 = new HashMap<>();
            rows_map4.put("day",day4);
            rows_map4.put("orders",orders[3]);
            rows_map4.put("customers",customers[3]);
            rows_map4.put("amount",amount[3]);
            rows_map4.put("pcr",pcr[3]);
            Map<String, Object> rows_map5 = new HashMap<>();
            rows_map5.put("day",day5);
            rows_map5.put("orders",orders[4]);
            rows_map5.put("customers",customers[4]);
            rows_map5.put("amount",amount[4]);
            rows_map5.put("pcr",pcr[4]);
            Map<String, Object> rows_map6 = new HashMap<>();
            rows_map6.put("day",day6);
            rows_map6.put("orders",orders[5]);
            rows_map6.put("customers",customers[5]);
            rows_map6.put("amount",amount[5]);
            rows_map6.put("pcr",pcr[5]);
            Map<String, Object> rows_map7 = new HashMap<>();
            rows_map7.put("day",day7);
            rows_map7.put("orders",orders[6]);
            rows_map7.put("customers",customers[6]);
            rows_map7.put("amount",amount[6]);
            rows_map7.put("pcr",pcr[6]);
            rows.add(rows_map1);
            rows.add(rows_map2);
            rows.add(rows_map3);
            rows.add(rows_map4);
            rows.add(rows_map5);
            rows.add(rows_map6);
            rows.add(rows_map7);

            Map<String, Object> map = new HashMap<>();
            map.put("columns",columns);
            map.put("rows",rows);

            return map;
        }
    }

    @Override
    public Map<String, Object> select_goods() {
        int[] orders = new int[7];
        boolean flag1 = true;
        for (int j = 0; j <7; j++) {
            orders[j] = (int)orderMapper.count_orders(j);
            if(orders[j] < 0){
                flag1 = false;
                break;
            }
        }
        int[] products = new int[7];
        boolean flag2 = true;
        for (int j = 0; j <7; j++) {
            if (orders[j] != 0) {
                products[j] = (int) orderGoodsMapper.count_products(j);
            }else{
                products[j] = 0;
            }
            if(products[j] < 0){
                flag2 = false;
                break;
            }
        }
        float[] amount = new float[7];
        boolean flag3 = true;
        for (int j = 0; j <7; j++) {
            if (orders[j] != 0){
                amount[j] = (float)orderGoodsMapper.count_goods_amount(j);
            }else{
                amount[j] = 0;
            }
            if(amount[j] < 0){
                flag3 = false;
                break;
            }
        }

        if(!(flag1&&flag2&&flag3)){
            return null;
        }else{
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,0);
            String day1 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day2 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day3 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day4 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day5 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day6 = df.format(calendar.getTime());
            calendar.add(calendar.DATE,-1);
            String day7 = df.format(calendar.getTime());

            List<String> columns = new LinkedList<>();
            columns.add("day");
            columns.add("orders");
            columns.add("products");
            columns.add("amount");

            List<Map> rows = new LinkedList<>();
            Map<String, Object> rows_map = new HashMap<>();
            rows_map.put("day",day1);
            rows_map.put("orders",orders[0]);
            rows_map.put("products",products[0]);
            rows_map.put("amount",amount[0]);
            Map<String, Object> rows_map1 = new HashMap<>();
            rows_map1.put("day",day2);
            rows_map1.put("orders",orders[1]);
            rows_map1.put("products",products[1]);
            rows_map1.put("amount",amount[1]);
            Map<String, Object> rows_map2 = new HashMap<>();
            rows_map2.put("day",day3);
            rows_map2.put("orders",orders[2]);
            rows_map2.put("products",products[2]);
            rows_map2.put("amount",amount[2]);
            Map<String, Object> rows_map3 = new HashMap<>();
            rows_map3.put("day",day4);
            rows_map3.put("orders",orders[3]);
            rows_map3.put("products",products[3]);
            rows_map3.put("amount",amount[3]);
            Map<String, Object> rows_map4 = new HashMap<>();
            rows_map4.put("day",day5);
            rows_map4.put("orders",orders[4]);
            rows_map4.put("products",products[4]);
            rows_map4.put("amount",amount[4]);
            Map<String, Object> rows_map5 = new HashMap<>();
            rows_map5.put("day",day6);
            rows_map5.put("orders",orders[5]);
            rows_map5.put("products",products[5]);
            rows_map5.put("amount",amount[5]);
            Map<String, Object> rows_map6 = new HashMap<>();
            rows_map6.put("day",day7);
            rows_map6.put("orders",orders[6]);
            rows_map6.put("products",products[6]);
            rows_map6.put("amount",amount[6]);
            rows.add(rows_map);
            rows.add(rows_map1);
            rows.add(rows_map2);
            rows.add(rows_map3);
            rows.add(rows_map4);
            rows.add(rows_map5);
            rows.add(rows_map6);


            Map<String, Object> map = new HashMap<>();
            map.put("columns",columns);
            map.put("rows",rows);

            return map;
        }
    }
}
