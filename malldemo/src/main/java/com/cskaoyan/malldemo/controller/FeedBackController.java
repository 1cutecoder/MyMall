package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Feedback;
import com.cskaoyan.malldemo.service.FeedBackService;
import com.cskaoyan.malldemo.util.ListToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("feedback")
public class FeedBackController {
    @Autowired
    FeedBackService feedBackService;
    @RequestMapping("list")
    @ResponseBody
    public Map queryFeedBack(String page,String limit ,String username,String sort,String order,String id){
        List<Feedback> feedbacks = feedBackService.queryFeedBackList(page, limit, username, sort, order, id);
        int i = feedBackService.quertTotalFeedBack();
        Map map = ListToMap.getMap(feedbacks, i);
        return map;
    }
}
