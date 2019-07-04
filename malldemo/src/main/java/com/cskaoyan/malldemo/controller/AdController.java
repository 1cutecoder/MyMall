
package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Ad;
import com.cskaoyan.malldemo.service.AdService;
import com.cskaoyan.malldemo.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ad")
public class AdController {
    @Autowired
    AdService adService;
    // 显示数据
    @RequestMapping("list")
    public Vo list(int page,int limit,Ad ad){
        List<Ad> allAd = adService.findAllAd(page, limit,ad);
        int count = (int)adService.selectCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",count);
        map.put("items",allAd);
        Vo vo = new Vo();
        vo.setData(map);
        String msg = "成功";
        vo.setErrmsg(msg);
        vo.setErrno(0);
        return vo;
    }

    // 删除一条数据
    @RequestMapping("delete")
    public Map delete(@RequestBody Ad ad){
        int i = adService.deleteAd(ad);
        HashMap<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("errmsg","成功");
            map.put("errno",0);
        }
        return map;

    }
    //插入数据
    @RequestMapping("create")
    public Map create(@RequestBody Ad ad){
        Date date = new Date();
        ad.setAddTime(date);
        ad.setUpdateTime(date);
        int i = adService.insertAd(ad);
        HashMap<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("errmsg","成功");
            map.put("errno",0);
        }
        return map;
    }
     @RequestMapping("update")
    public Map update(@RequestBody Ad ad){
         int i = adService.updateAd(ad);
         HashMap<String, Object> map = new HashMap<>();
         if(i!=0){
             map.put("errmsg","成功");
             map.put("errno",0);
         }
         return map;
     }
}

