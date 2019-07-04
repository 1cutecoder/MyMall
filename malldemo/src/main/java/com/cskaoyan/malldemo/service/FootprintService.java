package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Footprint;

import java.util.List;

public interface FootprintService {
    List<Footprint> queryFootprintList(String page, String limit, String userId, String goodsId, String sort, String order);

    int queryToatlFootprint();
}
