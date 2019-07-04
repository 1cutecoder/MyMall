package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Issue;
import com.cskaoyan.malldemo.bean.IssueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IssueMapper {
  long countByExample(IssueExample example);

  int deleteByExample(IssueExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(Issue record);

  int insertSelective(Issue record);

  List<Issue> selectByExample(IssueExample example);

  Issue selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") Issue record, @Param("example") IssueExample example);

  int updateByExample(@Param("record") Issue record, @Param("example") IssueExample example);

  int updateByPrimaryKeySelective(Issue record);

  int updateByPrimaryKey(Issue record);

  List<Issue> selectPage(@Param("question") String question,
                         @Param("startIndex") int startIndex,
                         @Param("pageSize") int pageSize,
                         @Param("sort") String sort,
                         @Param("order") String order);

  long selectCount(@Param("question") String question);

  int deleteById(@Param("issue") Issue issue);
}
