package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.SearchHistory;

import java.util.List;

public interface SearchHistoryService {
    List<SearchHistory> querySearchHistoryList(String page, String limit, String userId, String keyword, String sort, String order);

    int queryTotalSearchHistory();
}
