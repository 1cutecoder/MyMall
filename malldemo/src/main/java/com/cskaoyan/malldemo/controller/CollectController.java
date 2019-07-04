package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Collect;
import com.cskaoyan.malldemo.service.CollectService;
import com.cskaoyan.malldemo.util.ListToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("collect")
public class CollectController {
    @Autowired
    CollectService collectService;
    @RequestMapping("list")
    @ResponseBody
    public Map queryCollect(String page,String limit,String userId,String valueId,String sort,String order){
        List<Collect> collects = collectService.queryCollectList(page, limit, userId, valueId, sort, order);
        int i =collectService.queryTotalCollect();
        Map map = ListToMap.getMap(collects, i);
        return map;
    }
}
