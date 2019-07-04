package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Keyword;
import com.cskaoyan.malldemo.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by cute coder
 * 2019/5/24 17:33
 */
@Controller
@RequestMapping("keyword")
public class KeywordController {

  @Autowired
  KeywordService keywordService;

  @RequestMapping("list")
  @ResponseBody
  public Map list(Keyword keyword, int page, int limit, String sort, String order, Integer id, String name) {
    HashMap<String, Object> vo = new HashMap<>();
    HashMap<String, Object> data = new HashMap<>();
    List<Keyword> keywords = new LinkedList<>();
    keywords = keywordService.selectPage(keyword, page, limit, sort, order);
    long total = keywordService.slectCount(keyword);
    data.put("total", total);
    data.put("items", keywords);
    vo.put("data", data);
    vo.put("errno", 0);
    vo.put("errmsg", "成功");
    return vo;
  }

  @RequestMapping("create")
  @ResponseBody
  public Map create(@RequestBody Keyword keyword) {
    HashMap<String, Object> vo = new HashMap<>();
    Date date = new Date();
    keyword.setUpdateTime(date);
    keyword.setAddTime(date);
    int insert = keywordService.insert(keyword);
    if (insert == 1) {
      vo.put("data", keyword);
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

  @RequestMapping("delete")
  @ResponseBody
  public Map delete(@RequestBody Keyword keyword) {
    HashMap<String, Object> vo = new HashMap<>();
    keyword.setUpdateTime(new Date());
    int delete = keywordService.delete(keyword);
    if (delete == 1) {
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

  @RequestMapping("update")
  @ResponseBody
  public Map update(@RequestBody Keyword keyword) {
    HashMap<String, Object> vo = new HashMap<>();
    Date date = new Date();
    keyword.setUpdateTime(date);
    int update = keywordService.update(keyword);
    if (update == 1) {
      vo.put("data", keyword);
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

}
