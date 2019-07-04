package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.mapper.RoleMapper;
import com.cskaoyan.malldemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by cute coder
 * 2019/5/26 21:30
 */
@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  RoleMapper roleMapper;

  @Override
  public Set<String> queryByIds(Integer[] roleIds) {
    Set<String> names = roleMapper.queryByIds(roleIds);
    return names;
  }
}
