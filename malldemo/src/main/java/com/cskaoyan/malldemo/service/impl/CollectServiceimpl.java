package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Collect;
import com.cskaoyan.malldemo.bean.CollectExample;
import com.cskaoyan.malldemo.mapper.CollectMapper;
import com.cskaoyan.malldemo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceimpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;
    @Override
    public List<Collect> queryCollectList(String page, String limit, String userId, String valueId, String sort, String order) {
        int startPage = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
        int endPage = (Integer.parseInt(page))*Integer.parseInt(limit);
        List<Collect> collects = collectMapper.selectCollectList(startPage, endPage, userId, valueId, sort, order);
        return collects;
    }

    @Override
    public int queryTotalCollect() {
        CollectExample collectExample = new CollectExample();
        return (int) collectMapper.countByExample(collectExample);
    }
}
