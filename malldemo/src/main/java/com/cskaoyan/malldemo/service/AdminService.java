package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Admin;

/**
 * Created by cute coder
 * 2019/5/22 19:45
 */
public interface AdminService {

  Admin selectAdminByName(String username);

  int updateAdmin(Admin currentadmin);
}
