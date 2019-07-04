package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.User;
import com.cskaoyan.malldemo.bean.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    long count_users(@Param("i")int i);

    List<User> selectUserList(@Param("startPage") int startPage,@Param("endPage") int endPage,
                              @Param("sort") String sort,@Param("username") String username,@Param("order") String order,@Param("mobile") String mobile);
}
