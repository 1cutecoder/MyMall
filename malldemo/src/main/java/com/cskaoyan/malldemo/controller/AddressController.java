package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Address;
import com.cskaoyan.malldemo.bean.User;
import com.cskaoyan.malldemo.service.AddressService;
import com.cskaoyan.malldemo.util.ListToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @RequestMapping("list")
    @ResponseBody
    public Map queryAddress(String page, String limit, String sort, String name,String order,String userId){
        List<Address> list = addressService.queryAddressList(page, limit,sort,name,order,userId);
        int total = addressService.queryTotalAddress();
        Map map = ListToMap.getMap(list, total);
        return map;
    }
}
