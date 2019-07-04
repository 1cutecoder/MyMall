package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Comment;
import com.cskaoyan.malldemo.bean.CommentExample;
import com.cskaoyan.malldemo.mapper.CommentMapper;
import com.cskaoyan.malldemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> findAllComment(int page, int limit, Comment comment) {
        int startIndex= (page-1)*limit;
        int pageSize= limit;
        List<Comment> allComment = commentMapper.findAllComment(comment,startIndex, pageSize);
        return allComment;
    }

    @Override
    public long selectCount() {
        CommentExample example = new CommentExample();
        long count = commentMapper.countByExample(example);
        return count;
    }

    @Override
    public int deleteComment(Comment comment) {
        int i = commentMapper.deleteComment(comment);
        return i;
    }
}
