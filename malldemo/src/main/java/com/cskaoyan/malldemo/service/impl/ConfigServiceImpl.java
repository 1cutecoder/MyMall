package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.SystemExample;
import com.cskaoyan.malldemo.mapper.SystemMapper;
import com.cskaoyan.malldemo.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    SystemMapper systemMapper;

    @Override
    public Map<String, Object> select_mallconfig() {
        List<String> strings = new LinkedList<>();
        strings.add("cskaoyan_mall_mall_name");
        strings.add("cskaoyan_mall_mall_address");
        strings.add("cskaoyan_mall_mall_phone");
        strings.add("cskaoyan_mall_mall_qq");

        SystemExample systemExample = new SystemExample();
        SystemExample.Criteria criteria = systemExample.createCriteria();
        criteria.andKeyNameIn(strings);
        List<String> list = systemMapper.selectByExample_config(systemExample);

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("litemall_mall_name", list.get(0));
        stringObjectMap.put("litemall_mall_address", list.get(3));
        stringObjectMap.put("litemall_mall_phone", list.get(2));
        stringObjectMap.put("litemall_mall_qq", list.get(1));

        return stringObjectMap;
    }

    @Override
    public Map<String, Object> select_expressconfig() {
        List<String> strings = new LinkedList<>();
        strings.add("cskaoyan_mall_express_freight_min");
        strings.add("cskaoyan_mall_express_freight_value");

        SystemExample systemExample = new SystemExample();
        SystemExample.Criteria criteria = systemExample.createCriteria();
        criteria.andKeyNameIn(strings);
        List<String> list = systemMapper.selectByExample_config(systemExample);

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("litemall_express_freight_min", list.get(0));
        stringObjectMap.put("litemall_express_freight_value", list.get(1));

        return stringObjectMap;
    }

    @Override
    public Map<String, Object> select_orderconfig() {
        List<String> strings = new LinkedList<>();
        strings.add("cskaoyan_mall_order_unpaid");
        strings.add("cskaoyan_mall_order_unconfirm");
        strings.add("cskaoyan_mall_order_comment");

        SystemExample systemExample = new SystemExample();
        SystemExample.Criteria criteria = systemExample.createCriteria();
        criteria.andKeyNameIn(strings);
        List<String> list = systemMapper.selectByExample_config(systemExample);

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("litemall_order_unpaid", list.get(0));
        stringObjectMap.put("litemall_order_unconfirm", list.get(1));
        stringObjectMap.put("litemall_order_comment", list.get(2));

        return stringObjectMap;
    }

    @Override
    public Map<String, Object> select_wxconfig() {
        List<String> strings = new LinkedList<>();
        strings.add("cskaoyan_mall_wx_index_new");
        strings.add("cskaoyan_mall_wx_index_hot");
        strings.add("cskaoyan_mall_wx_index_brand");
        strings.add("cskaoyan_mall_wx_index_topic");
        strings.add("cskaoyan_mall_wx_catlog_list");
        strings.add("cskaoyan_mall_wx_catlog_goods");
        strings.add("cskaoyan_mall_wx_share");

        SystemExample systemExample = new SystemExample();
        SystemExample.Criteria criteria = systemExample.createCriteria();
        criteria.andKeyNameIn(strings);
        List<String> list = systemMapper.selectByExample_config(systemExample);

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("litemall_wx_index_new", list.get(0));
        stringObjectMap.put("litemall_wx_index_hot", list.get(2));
        stringObjectMap.put("litemall_wx_index_brand", list.get(5));
        stringObjectMap.put("litemall_wx_index_topic", list.get(6));
        stringObjectMap.put("litemall_wx_catlog_list", list.get(4));
        stringObjectMap.put("litemall_wx_catlog_goods", list.get(3));
        stringObjectMap.put("litemall_wx_share", list.get(1));

        return stringObjectMap;
    }

    @Override
    public int update_mallconfig(Map<String, String> data) {
        int i = systemMapper.update_mallconfig(data.get("litemall_mall_name"), data.get("litemall_mall_address"),
                data.get("litemall_mall_phone"), data.get("litemall_mall_qq"));
        return i;
    }

    @Override
    public int update_expressconfig(Map<String, String> data) {
        int i = systemMapper.update_expressconfig(data.get("litemall_express_freight_min"), data.get("litemall_express_freight_value"));
        return i;
    }

    @Override
    public int update_orderconfig(Map<String, String> data) {
        int i = systemMapper.update_orderconfig(data.get("litemall_order_unpaid"), data.get("litemall_order_unconfirm"),
                data.get("litemall_order_comment"));
        return i;
    }

    @Override
    public int update_wxconfig(Map<String, String> data) {
        int i = systemMapper.update_wxconfig(data.get("litemall_wx_index_new"), data.get("litemall_wx_index_hot"),
                data.get("litemall_wx_index_brand"), data.get("litemall_wx_index_topic"), data.get("litemall_wx_catlog_list"),
                data.get("litemall_wx_catlog_goods"), data.get("litemall_wx_share"));
        return i;
    }
}
