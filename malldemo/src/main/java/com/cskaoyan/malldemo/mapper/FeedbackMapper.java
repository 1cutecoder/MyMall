package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Feedback;
import com.cskaoyan.malldemo.bean.FeedbackExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {
    long countByExample(FeedbackExample example);

    int deleteByExample(FeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> selectByExample(FeedbackExample example);

    Feedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    List<Feedback> selectFeedBackList(@Param("startPage") int startPage,@Param("endPage") int endPage,@Param("username") String username,@Param("sort") String sort,@Param("order") String order,@Param("id") String id);
}
