package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Issue;
import com.cskaoyan.malldemo.mapper.IssueMapper;
import com.cskaoyan.malldemo.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/24 16:44
 */
@Service
public class IssueServiceImpl implements IssueService {
  @Autowired
  IssueMapper issueMapper;

  @Override
  public List<Issue> selectPage(String question, int page, int limit, String sort, String order) {
    int startIndex = (page - 1) * limit;
    int pageSize = limit;
    return issueMapper.selectPage(question, startIndex, pageSize, sort, order);
  }

  @Override
  public long slectCount(String question) {
    long count = issueMapper.selectCount(question);
    return count;
  }

  @Override
  public int insert(Issue issue) {
    int i = issueMapper.insertSelective(issue);
    return i;
  }

  @Override
  public int delete(Issue issue) {
    int i = issueMapper.deleteById(issue);
    return i;
  }

  @Override
  public int update(Issue issue) {
    int update = issueMapper.updateByPrimaryKey(issue);
    return update;
  }
}
