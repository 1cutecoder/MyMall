package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Collect;

import java.util.List;

public interface CollectService {
    List<Collect> queryCollectList(String page, String limit, String userId, String valueId, String sort, String order);

    int queryTotalCollect();
}
