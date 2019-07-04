package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Admin;
import com.cskaoyan.malldemo.bean.AdminExample;
import com.cskaoyan.malldemo.mapper.AdminMapper;
import com.cskaoyan.malldemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/22 19:45
 */
@Service
public class AdminServiceImpl  implements AdminService {
  @Autowired
  AdminMapper adminMapper;
  @Override
  public Admin selectAdminByName(String username) {
    List<Admin> admins = adminMapper.selectByUsername(username);
    if (admins!=null && admins.size()>=1) {
      return admins.get(0);
    }
    return null;
  }

  @Override
  public int updateAdmin(Admin currentadmin) {
    int update = adminMapper.updateByPrimaryKey(currentadmin);
    return update;
  }
}
