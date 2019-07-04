package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Issue;
import com.cskaoyan.malldemo.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by cute coder
 * 2019/5/24 16:40
 */
@Controller
@RequestMapping("issue")
public class IssueController {
  @Autowired
  IssueService issueService;

  @RequestMapping("list")
  @ResponseBody
  public Map list(String question, int page, int limit, String sort, String order, Integer id, String name) {
    HashMap<String, Object> vo = new HashMap<>();
    HashMap<String, Object> data = new HashMap<>();
    List<Issue> issues = new LinkedList<>();
    issues = issueService.selectPage(question, page, limit, sort, order);
    long total = issueService.slectCount(question);
    data.put("total", total);
    data.put("items", issues);
    vo.put("data", data);
    vo.put("errno", 0);
    vo.put("errmsg", "成功");
    return vo;
  }

  @RequestMapping("create")
  @ResponseBody
  public Map create(@RequestBody Issue issue) {
    HashMap<String, Object> vo = new HashMap<>();
    Date date = new Date();
    issue.setUpdateTime(date);
    issue.setAddTime(date);
    int insert = issueService.insert(issue);
    if (insert == 1) {
      vo.put("data", issue);
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

  @RequestMapping("delete")
  @ResponseBody
  public Map delete(@RequestBody Issue issue) {
    HashMap<String, Object> vo = new HashMap<>();
    issue.setUpdateTime(new Date());
    int delete = issueService.delete(issue);
    if (delete == 1) {
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

  @RequestMapping("update")
  @ResponseBody
  public Map update(@RequestBody Issue issue) {
    HashMap<String, Object> vo = new HashMap<>();
    Date date = new Date();
    issue.setUpdateTime(date);
    int update = issueService.update(issue);
    if (update == 1) {
      vo.put("data", issue);
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

}
