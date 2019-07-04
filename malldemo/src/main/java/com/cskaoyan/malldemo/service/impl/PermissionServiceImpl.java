package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.mapper.PermissionMapper;
import com.cskaoyan.malldemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by cute coder
 * 2019/5/26 21:27
 */
@Service
public class PermissionServiceImpl implements PermissionService {

  @Autowired
  PermissionMapper permissionMapper;

  @Override
  public Set<String> queryByRoleIds(Integer[] roleIds) {
    Set<String> permissions = permissionMapper.queryByRoleIds(roleIds);
    return permissions;
  }
}
