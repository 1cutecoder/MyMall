package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Address;
import com.cskaoyan.malldemo.bean.User;

import java.util.List;

public interface AddressService {

    List<Address> queryAddressList(String page, String limit, String sort, String username, String order, String mobile);

    int queryTotalAddress();
}
