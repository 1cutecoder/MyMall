package com.cskaoyan.malldemo.shiro;

import com.cskaoyan.malldemo.bean.Admin;
import com.cskaoyan.malldemo.service.AdminService;
import com.cskaoyan.malldemo.service.PermissionService;
import com.cskaoyan.malldemo.service.RoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/*
 *
 * Created by cute coder
 * 2019/5/25 10:56

 */

@Component
public class CustomRealm extends AuthorizingRealm {


  @Autowired
  AdminService adminService;

  @Autowired
  RoleService roleService;

  @Autowired
  PermissionService permissionService;

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    String username = (String) token.getPrincipal();
    String password = null;
    AuthenticationInfo auInfo = null;
    if (username != null) {
      Admin admin = adminService.selectAdminByName(username);
      if (admin != null) {
        password = admin.getPassword();
        auInfo = new SimpleAuthenticationInfo(admin, password, this.getName());
      }
    }
    return auInfo;
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    Admin admin = (Admin) principals.getPrimaryPrincipal();
    Integer[] roleIds = admin.getRoleIds();
    Set<String> roles = roleService.queryByIds(roleIds);
    Set<String> permissions = permissionService.queryByRoleIds(roleIds);
    SimpleAuthorizationInfo auInfo = new SimpleAuthorizationInfo();
    auInfo.addStringPermissions(permissions);
    auInfo.addRoles(roles);
    return auInfo;
  }
}
