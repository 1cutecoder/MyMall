package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Topic;
import com.cskaoyan.malldemo.bean.TopicExample;
import com.cskaoyan.malldemo.mapper.TopicMapper;
import com.cskaoyan.malldemo.service.TopicService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;
    @Override
    public List<Topic> findAllTopic(int page, int limit,Topic topic) {
        PageHelper.startPage(page,limit);
        List<Topic> allTopic = topicMapper.findAllTopic(topic);
        return allTopic;
    }

    @Override
    public long topicCount() {
        TopicExample example = new TopicExample();
        long count = topicMapper.countByExample(example);
        return count;
    }
// 删除单条数据
    @Override
    public int deleteTopic(Topic topic) {
        int i = topicMapper.deleteTopic(topic);
        return i;
    }

    @Override
    public int insertTopic(Topic topic) {
        int i = topicMapper.insertTopic(topic);
        return i;
    }

    @Override
    public int updateTopic(Topic topic) {
        int i = topicMapper.updateByPrimaryKeySelective(topic);
        return i;
    }
}
