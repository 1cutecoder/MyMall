package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.SearchHistory;
import com.cskaoyan.malldemo.service.SearchHistoryService;
import com.cskaoyan.malldemo.util.ListToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("history")
@Controller
public class SearchHistoryController {
    @Autowired
    SearchHistoryService searchHistoryService;
    @RequestMapping("list")
    @ResponseBody
    public Map querySearchHistory(String page,String limit,String userId,String keyword,String sort,String order){
        List<SearchHistory> searchHistories = searchHistoryService.querySearchHistoryList(page, limit, userId, keyword, sort, order);
        int i = searchHistoryService.queryTotalSearchHistory();
        Map map = ListToMap.getMap(searchHistories, i);
        return map;
    }
}
