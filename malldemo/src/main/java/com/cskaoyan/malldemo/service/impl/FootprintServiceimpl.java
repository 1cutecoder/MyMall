package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Footprint;
import com.cskaoyan.malldemo.bean.FootprintExample;
import com.cskaoyan.malldemo.mapper.FootprintMapper;
import com.cskaoyan.malldemo.service.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintServiceimpl implements FootprintService {
    @Autowired
    FootprintMapper footprintMapper;
    @Override
    public List<Footprint> queryFootprintList(String page, String limit, String userId, String goodsId, String sort, String order) {
        int startPage = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
        int endPage = (Integer.parseInt(page))*Integer.parseInt(limit);
        List<Footprint> footprints = footprintMapper.selectFootprintList(startPage, endPage, userId, goodsId, sort, order);
        return footprints;
    }

    @Override
    public int queryToatlFootprint() {
        return (int) footprintMapper.countByExample(new FootprintExample());
    }
}
