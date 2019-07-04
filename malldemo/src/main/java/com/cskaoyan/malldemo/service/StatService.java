package com.cskaoyan.malldemo.service;

import java.util.Map;

public interface StatService {
    Map<String, Object> select_user();

    Map<String, Object> select_order();

    Map<String, Object> select_goods();
}
