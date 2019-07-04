package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Footprint;
import com.cskaoyan.malldemo.service.FootprintService;
import com.cskaoyan.malldemo.util.ListToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("footprint")
@Controller
public class FootprintController {
    @Autowired
    FootprintService footprintService;
    @RequestMapping("list")
    @ResponseBody
    public Map queryFootprint(String page,String limit,String userId,String goodsId,String sort,String order){
        List<Footprint> list = footprintService.queryFootprintList(page, limit, userId, goodsId, sort, order);
        int i = footprintService.queryToatlFootprint();
        Map map = ListToMap.getMap(list, i);
        return map;
    }
}
