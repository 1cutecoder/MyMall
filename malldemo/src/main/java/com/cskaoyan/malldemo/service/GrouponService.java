package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Goods;
import com.cskaoyan.malldemo.bean.Groupon;
import com.cskaoyan.malldemo.bean.Groupon_rules;
import com.cskaoyan.malldemo.bean.Param;

import java.util.List;

public interface GrouponService {
    List<Groupon_rules> findAllGroupon(int page, int limit, Groupon_rules grouponRules);

    long grouponCount();

    int deleteGroup(Groupon_rules grouponRules);

    int addGrouponRules(Groupon_rules grouponRules, Goods goods);

    Goods selectGoodById(Integer goodsId);

    int updateGrouponRules(Groupon_rules grouponRules, Goods goods);

    List<Groupon> selectRecord(Param param, Groupon groupon);
}
