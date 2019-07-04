package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.User;
import com.cskaoyan.malldemo.service.UserService;
import com.cskaoyan.malldemo.util.ListToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("list")
    @ResponseBody
    public Map queryUser(String page, String limit, String sort, String username,String order,String mobile){
        List<User> list = userService.queryUserList(page, limit,sort,username,order,mobile);
        int total = userService.queryTotalUser();
        Map map = ListToMap.getMap(list, total);
        return map;
    }
}
