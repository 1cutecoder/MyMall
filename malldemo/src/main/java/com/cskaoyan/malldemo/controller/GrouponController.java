package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Goods;
import com.cskaoyan.malldemo.bean.Groupon;
import com.cskaoyan.malldemo.bean.Groupon_rules;
import com.cskaoyan.malldemo.bean.Param;
import com.cskaoyan.malldemo.service.GrouponService;
import com.cskaoyan.malldemo.vo.Vo;
import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("groupon")
public class GrouponController {
    @Autowired
    GrouponService grouponService;
    @RequestMapping("list")
    public Vo list(int page, int limit, Groupon_rules grouponRules){
        List<Groupon_rules> allGroupon = grouponService.findAllGroupon(page, limit, grouponRules);
        int count = (int)grouponService.grouponCount();
        Vo vo = new Vo();
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",allGroupon);
        map.put("total",count);
        vo.setData(map);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }
    //删除
    @RequestMapping("delete")
    public Map delete(@RequestBody Groupon_rules grouponRules){
        int i = grouponService.deleteGroup(grouponRules);
        HashMap<String, Object> map = new HashMap<>();
        if(i != 0){
            map.put("errmsg","成功");
            map.put("errno",0);
        }
        return map;
    }
    // 增加
    @RequestMapping("create")
    public Map create (@RequestBody Groupon_rules grouponRules) {
        // Object discount = grouponRules.get("discount");
        HashMap<String, Object> map = new HashMap<>();
        Integer goodsId = grouponRules.getGoodsId();
        Goods goods = grouponService.selectGoodById(goodsId);
        if (goods == null) {
            map.put("errmsg", "参数值不对");
            map.put("errno", 402);
        } else {
            int i = grouponService.addGrouponRules(grouponRules, goods);
            if (i != 0) {
                map.put("errmsg", "成功");
                map.put("errno", 0);
            }
        }
        return map;
    }
    // 编辑
    @RequestMapping("update")
    public Map update (@RequestBody Groupon_rules grouponRules) {
        // Object discount = grouponRules.get("discount");
        HashMap<String, Object> map = new HashMap<>();
        Integer goodsId = grouponRules.getGoodsId();
        Goods goods = grouponService.selectGoodById(goodsId);
        if (goods == null) {
            map.put("errmsg", "参数值不对");
            map.put("errno", 402);
        } else {
            int i = grouponService.updateGrouponRules(grouponRules, goods);
            if (i != 0) {
                map.put("errmsg", "成功");
                map.put("errno", 0);
            }
        }
        return map;
    }
    //团购活动
    @RequestMapping("listRecord")
    public Vo listRecord(Param param,Groupon groupon){
        List<Groupon> groupons = grouponService.selectRecord(param,groupon);

        Vo vo = new Vo();
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",groupons);
        vo.setData(map);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }

}
