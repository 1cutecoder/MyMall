package com.cskaoyan.malldemo.service;

import java.util.Map;

public interface ConfigService {
    Map<String, Object> select_mallconfig();

    Map<String, Object> select_expressconfig();

    Map<String, Object> select_orderconfig();

    Map<String, Object> select_wxconfig();

    int update_mallconfig(Map<String, String> data);

    int update_expressconfig(Map<String, String> data);

    int update_orderconfig(Map<String, String> data);

    int update_wxconfig(Map<String, String> data);

}
