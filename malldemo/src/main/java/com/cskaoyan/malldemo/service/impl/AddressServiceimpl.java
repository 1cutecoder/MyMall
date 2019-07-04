package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Address;
import com.cskaoyan.malldemo.bean.AdminExample;
import com.cskaoyan.malldemo.bean.User;
import com.cskaoyan.malldemo.mapper.AddressMapper;
import com.cskaoyan.malldemo.mapper.AdminMapper;
import com.cskaoyan.malldemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceimpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public List<Address> queryAddressList(String page, String limit, String sort, String name,String order,String userId) {
        int startPage = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
        int endPage = (Integer.parseInt(page))*Integer.parseInt(limit);
        List<Address> list =addressMapper.selectAddressList(startPage,endPage,sort,name,order,userId);
        return list;
    }

    @Override
    public int queryTotalAddress() {
        AdminExample adminExample=new AdminExample();
        long l = addressMapper.countByExample(adminExample);
        return (int)l;
    }
}
