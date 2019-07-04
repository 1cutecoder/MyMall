package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAllComment(int page, int limit, Comment comment);

    long selectCount();

    int deleteComment(Comment comment);
}
