package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Feedback;
import com.cskaoyan.malldemo.bean.FeedbackExample;
import com.cskaoyan.malldemo.mapper.FeedbackMapper;
import com.cskaoyan.malldemo.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceimpl implements FeedBackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    @Override
    public List<Feedback> queryFeedBackList(String page, String limit, String username, String sort, String order, String id) {
        int startPage = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
        int endPage = (Integer.parseInt(page))*Integer.parseInt(limit);
        List<Feedback> feedbacks = feedbackMapper.selectFeedBackList(startPage, endPage, username, sort, order, id);
        return feedbacks;
    }

    @Override
    public int quertTotalFeedBack() {
        return (int)feedbackMapper.countByExample(new FeedbackExample());
    }
}
