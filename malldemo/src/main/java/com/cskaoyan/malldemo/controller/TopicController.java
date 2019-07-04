package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Ad;
import com.cskaoyan.malldemo.bean.Topic;
import com.cskaoyan.malldemo.service.TopicService;
import com.cskaoyan.malldemo.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("topic")
public class TopicController {
    @Autowired
    TopicService topicService;
    @RequestMapping("list")
    public Vo list(int page,int limit,Topic topic){
        List<Topic> allTopic = topicService.findAllTopic(page, limit,topic);
        long count = topicService.topicCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",count);
        map.put("items",allTopic);
        Vo vo = new Vo();
        vo.setData(map);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }
    // 删除单条数据
    @RequestMapping("delete")
    public Map delete(@RequestBody Topic topic){
        HashMap<String, Object> map = new HashMap<>();
        int i = topicService.deleteTopic(topic);
        if(i != 0){
            map.put("errmsg","成功");
            map.put("errno",0);
        }
        return map;
    }
    // 添加数据
    @RequestMapping("create")
    public Map create(@RequestBody Topic topic){
        Date date = new Date();
        topic.setAddTime(date);
        topic.setUpdateTime(date);
        int i = topicService.insertTopic(topic);
        HashMap<String, Object> map = new HashMap<>();
        if(i != 0){
            map.put("errmsg","成功");
            map.put("errno",0);
        }
        return map;
    }
    // 编辑
    @RequestMapping("update")
    public Map update(@RequestBody Topic topic){
        int i = topicService.updateTopic(topic);
        HashMap<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("errmsg","成功");
            map.put("errno",0);
        }
        return map;
    }
}
