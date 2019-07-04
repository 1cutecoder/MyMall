package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Keyword;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/24 17:34
 */
public interface KeywordService {
  List<Keyword> selectPage(Keyword keyword, int page, int limit, String sort, String order);

  long slectCount(Keyword keyword);

  int insert(Keyword keyword);

  int delete(Keyword keyword);

  int update(Keyword keyword);
}
