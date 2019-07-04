package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Issue;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/24 16:44
 */
public interface IssueService {
  List<Issue> selectPage(String question, int page, int limit, String sort, String order);

  long slectCount(String question);

  int insert(Issue issue);

  int delete(Issue issue);

  int update(Issue issue);
}
