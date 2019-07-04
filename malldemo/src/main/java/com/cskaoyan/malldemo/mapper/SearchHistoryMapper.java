package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.SearchHistory;
import com.cskaoyan.malldemo.bean.SearchHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchHistoryMapper {
    long countByExample(SearchHistoryExample example);

    int deleteByExample(SearchHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    List<SearchHistory> selectByExample(SearchHistoryExample example);

    SearchHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchHistory record, @Param("example") SearchHistoryExample example);

    int updateByExample(@Param("record") SearchHistory record, @Param("example") SearchHistoryExample example);

    int updateByPrimaryKeySelective(SearchHistory record);

    int updateByPrimaryKey(SearchHistory record);

    List<SearchHistory> selectSearchHistoryList(@Param("startPage") int startPage,@Param("endPage") int endPage,@Param("userId") String userId,@Param("keyword") String keyword, @Param("sort") String sort,@Param("order") String order);
}
