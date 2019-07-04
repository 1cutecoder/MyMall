package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.User;
import com.cskaoyan.malldemo.bean.UserExample;
import com.cskaoyan.malldemo.mapper.UserMapper;
import com.cskaoyan.malldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
  @Autowired
  UserMapper userMapper;

  @Override
  public List<User> queryUserList(String page, String limit, String sort, String username, String order, String mobile) {
    int startPage = (Integer.parseInt(page) - 1) * Integer.parseInt(limit);
    int endPage = (Integer.parseInt(page)) * Integer.parseInt(limit);
    List<User> list = userMapper.selectUserList(startPage, endPage, sort, username, order, mobile);
    return list;
  }

  @Override
  public int queryTotalUser() {
    UserExample userExample = new UserExample();
    long l = userMapper.countByExample(userExample);
    return (int) l;
  }

  @Override
  public User selectByUsername(String username) {
    UserExample userExample = new UserExample();
    userExample.createCriteria().andUsernameEqualTo(username);
    List<User> users = userMapper.selectByExample(userExample);
    if (users != null) {
      return users.get(0);
    }
    return null;
  }

  @Override
  public long slectCount() {
    long count = userMapper.countByExample(new UserExample());
    return count;
  }
}
