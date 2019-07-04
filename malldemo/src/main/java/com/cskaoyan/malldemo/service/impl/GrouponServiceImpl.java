package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.*;
import com.cskaoyan.malldemo.mapper.GoodsMapper;
import com.cskaoyan.malldemo.mapper.Groupon_rulesMapper;
import com.cskaoyan.malldemo.mapper.RecordMapper;
import com.cskaoyan.malldemo.service.GrouponService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrouponServiceImpl implements GrouponService {
    @Autowired
    Groupon_rulesMapper grouponRulesMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    RecordMapper recordMapper;
    @Override
    public List<Groupon_rules> findAllGroupon(int page, int limit, Groupon_rules grouponRules) {
        List<Groupon_rules> allGroupon = grouponRulesMapper.findAllGroupon(grouponRules);
        return allGroupon;
    }

    @Override
    public long grouponCount() {
        Groupon_rulesExample example = new Groupon_rulesExample();
        long count = grouponRulesMapper.countByExample(example);
        return count;
    }

    @Override
    public int deleteGroup(Groupon_rules grouponRules) {
        int i = grouponRulesMapper.deleteGroup(grouponRules);
        return i;
    }

    @Override
    public int addGrouponRules(Groupon_rules grouponRules,Goods goods) {
        int i = grouponRulesMapper.insertGrouponRules(grouponRules,goods);
        return i;
    }

    @Override
    public Goods selectGoodById(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }

    @Override
    public int updateGrouponRules(Groupon_rules grouponRules, Goods goods) {
        int i = grouponRulesMapper.updateGrouponRules(grouponRules, goods);
        return i;
    }

    @Override
    public List<Groupon> selectRecord(Param param,Groupon groupon) {
        int page = param.getPage();
        int limit = param.getLimit();
        PageHelper.startPage(page,limit);
        List<Groupon> groupons = recordMapper.selectRecord(param,groupon);
        return groupons;
    }
}
