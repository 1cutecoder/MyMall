package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.User;

import java.util.List;

public interface UserService {
    List<User> queryUserList(String page, String limit, String sort, String username, String order, String mobile);

    int queryTotalUser();

    User selectByUsername(String username);

  long slectCount();

}
