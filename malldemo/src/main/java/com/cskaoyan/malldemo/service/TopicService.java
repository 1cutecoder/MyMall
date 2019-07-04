package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> findAllTopic(int page, int limit, Topic topic);

    long topicCount();

    int deleteTopic(Topic topic);

    int insertTopic(Topic topic);

    int updateTopic(Topic topic);
}
