package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.SearchHistory;
import com.cskaoyan.malldemo.bean.SearchHistoryExample;
import com.cskaoyan.malldemo.mapper.SearchHistoryMapper;
import com.cskaoyan.malldemo.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchHistoryServiceimpl implements SearchHistoryService {
    @Autowired
    SearchHistoryMapper searchHistoryMapper;
    @Override
    public List<SearchHistory> querySearchHistoryList(String page, String limit, String userId, String keyword, String sort, String order) {
        int startPage = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
        int endPage = (Integer.parseInt(page))*Integer.parseInt(limit);
        List<SearchHistory> searchHistories = searchHistoryMapper.selectSearchHistoryList(startPage, endPage, userId, keyword, sort, order);
        return searchHistories;
    }

    @Override
    public int queryTotalSearchHistory() {
        return (int) searchHistoryMapper.countByExample(new SearchHistoryExample());
    }
}
