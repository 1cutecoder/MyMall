package com.cskaoyan.malldemo.service;

import java.util.Set;

/**
 * Created by cute coder
 * 2019/5/26 21:26
 */
public interface RoleService {
  Set<String> queryByIds(Integer[] roleIds);
}
