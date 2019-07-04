package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Feedback;

import java.util.List;

public interface FeedBackService {
    List<Feedback> queryFeedBackList(String page, String limit, String username, String sort, String order, String id);

    int quertTotalFeedBack();
}
