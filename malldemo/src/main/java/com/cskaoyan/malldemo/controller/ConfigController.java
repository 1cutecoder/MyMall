package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.service.ConfigService;
import com.cskaoyan.malldemo.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    ConfigService configService;

    @RequestMapping(value = "/mall", method = RequestMethod.GET)
    public Vo mall_get(){
        Vo vo = new Vo();
        Map<String, Object> map =  configService.select_mallconfig();
        if(map.isEmpty()){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setData(map);
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }

    @RequestMapping(value = "/mall", method = RequestMethod.POST)
    public Vo mall_post(@RequestBody Map<String, String> data){
        Vo vo = new Vo();
        int i =  configService.update_mallconfig(data);
        if(i == 0){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }

    @RequestMapping(value = "/express", method = RequestMethod.GET)
    public Vo express_get(){
        Vo vo = new Vo();
        Map<String, Object> map =  configService.select_expressconfig();
        if(map.isEmpty()){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setData(map);
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }

    @RequestMapping(value = "/express", method = RequestMethod.POST)
    public Vo express_post(@RequestBody Map<String, String> data){
        Vo vo = new Vo();
        int i =  configService.update_expressconfig(data);
        if(i == 0){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Vo order_get(){
        Vo vo = new Vo();
        Map<String, Object> map =  configService.select_orderconfig();
        if(map.isEmpty()){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setData(map);
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Vo order_post(@RequestBody Map<String, String> data){
        Vo vo = new Vo();
        int i =  configService.update_orderconfig(data);
        if(i == 0){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }

    @RequestMapping(value = "/wx", method = RequestMethod.GET)
    public Vo wx_get(){
        Vo vo = new Vo();
        Map<String, Object> map =  configService.select_wxconfig();
        if(map.isEmpty()){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setData(map);
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }

    @RequestMapping(value = "/wx", method = RequestMethod.POST)
    public Vo wx_post(@RequestBody Map<String, String> data){
        Vo vo = new Vo();
        int i =  configService.update_wxconfig(data);
        if(i == 0){
            vo.setErrmsg("失败");
            vo.setErrno(1);
        } else {
            vo.setErrmsg("成功");
            vo.setErrno(0);
        }
        return vo;
    }
}
