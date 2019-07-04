package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Comment;
import com.cskaoyan.malldemo.service.CommentService;
import com.cskaoyan.malldemo.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    // 显示数据
    @RequestMapping("/list")
    public Vo list(int page, int limit, Comment comment){
        List<Comment> allComment = commentService.findAllComment(page,limit,comment);
        int count = (int)commentService.selectCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",count);
        map.put("items",allComment);
        Vo vo = new Vo();
        vo.setData(map);
        String msg = "成功";
        vo.setErrmsg(msg);
        vo.setErrno(0);
        return vo;
    }

    // 删除一条数据
    @RequestMapping("delete")
    public HashMap<String, Object> delete(@RequestBody Comment comment){
        int i = commentService.deleteComment(comment);
        HashMap<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("errmsg","成功");
            map.put("errno",0);
        }
        return map;
    }
}

