package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Keyword;
import com.cskaoyan.malldemo.mapper.KeywordMapper;
import com.cskaoyan.malldemo.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/24 17:34
 */
@Service
public class KeywordServieImpl implements KeywordService {

  @Autowired
  KeywordMapper keywordMapper;
  @Override
  public List<Keyword> selectPage(Keyword keyword, int page, int limit, String sort, String order) {
    int startIndex = (page - 1) * limit;
    int pageSize = limit;
    return keywordMapper.selectPage(keyword, startIndex, pageSize, sort, order);
  }

  @Override
  public long slectCount(Keyword keyword) {
    long count = keywordMapper.selectCount(keyword);
    return count;
  }

  @Override
  public int insert(Keyword keyword) {
    int i = keywordMapper.insertSelective(keyword);
    return i;
  }

  @Override
  public int delete(Keyword keyword) {
    int i = keywordMapper.deleteById(keyword);
    return i;
  }

  @Override
  public int update(Keyword keyword) {
    int update = keywordMapper.updateByPrimaryKey(keyword);
    return update;
  }
}
