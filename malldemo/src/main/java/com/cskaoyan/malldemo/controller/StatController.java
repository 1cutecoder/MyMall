package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.service.StatService;
import com.cskaoyan.malldemo.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/stat")
public class StatController {
    @Autowired
    StatService statService;

    @RequestMapping("/user")
    public Vo user(){
        Vo vo = new Vo();
        Map<String, Object> map =  statService.select_user();
        if(map == null){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setData(map);
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }

    @RequestMapping("/order")
    public Vo order(){
        Vo vo = new Vo();
        Map<String, Object> map =  statService.select_order();
        if(map == null){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setData(map);
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }

    @RequestMapping("/goods")
    public Vo goods(){
        Vo vo = new Vo();
        Map<String, Object> map =  statService.select_goods();
        if(map == null){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setData(map);
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }
}
