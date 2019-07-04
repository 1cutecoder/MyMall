package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Admin;
import com.cskaoyan.malldemo.service.*;
import com.cskaoyan.malldemo.util.Json2Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by cute coder
 * 2019/5/22 17:12
 */
@Controller
public class MainController {

  @Autowired
  AdminService adminService;

  @Autowired
  UserService userService;

  @Autowired
  GoodsService goodsService;

  @Autowired
  ProductService productService;

  @Autowired
  OrderService orderService;

  @Autowired
  RoleService roleService;

  @Autowired
  PermissionService permissionService;
  @RequestMapping("/auth/login")
  @ResponseBody
  public Map auth(@RequestBody Admin admin,HttpServletRequest request) {
    HashMap<String, Object> vo = new HashMap<>();
    HashMap<String, Object> data = new HashMap<>();
    Subject currentUser = SecurityUtils.getSubject();
    UsernamePasswordToken token = null;
    if (!currentUser.isAuthenticated()) {
      token = new UsernamePasswordToken(admin.getUsername(), admin.getPassword());
      try {
        currentUser.login(token);
      } catch (AuthenticationException e) {
        return vo;
      }
    }
    currentUser = SecurityUtils.getSubject();
    Admin currentadmin = (Admin) currentUser.getPrincipal();
    updateAdmin(currentadmin,request);
    Map<String, Object> adminInfo = new HashMap<>();
    adminInfo.put("nickName", currentadmin.getUsername());
    adminInfo.put("avatar", currentadmin.getAvatar());
    data.put("token", currentUser.getSession().getId());
    data.put("adminInfo", adminInfo);
    vo.put("data", data);
    vo.put("errno", 0);
    vo.put("errmsg", "成功");
    return vo;
  }

  private void updateAdmin(Admin currentadmin,HttpServletRequest request) {
    currentadmin.setLastLoginIp(request.getRemoteAddr());
    currentadmin.setLastLoginTime(new Date());
    currentadmin.setUpdateTime(new Date());
    adminService.updateAdmin(currentadmin);
  }

  @RequestMapping("/sockjs-node/info")
  @ResponseBody
  public Map info(@RequestBody Admin admin, HttpServletRequest request) {
    HashMap<String, Object> vo = new HashMap<>();
    LinkedList<Object> list = new LinkedList<>();
    list.add("*:*");
    vo.put("websocket", "true");
    vo.put("origins", list);
    vo.put("cookie_needed", "false");
    vo.put("entropy", "3441846575");
    return vo;
  }

  @RequestMapping("/auth/info")
  @ResponseBody
  public Map info(HttpServletRequest request) {
    String header = request.getHeader("X-Litemall-Admin-Token");
    Map<String, Object> map = Json2Map.json2Map(header);
    Map<String,Object> adminInfo = (Map<String, Object>) map.get("adminInfo");
    String nickName = (String) adminInfo.get("nickName");
    Admin admin = adminService.selectAdminByName(nickName);
    HashMap<String, Object> vo = new HashMap<>();
    Map<String, Object> data = new HashMap<>();
    if (admin!=null) {
      data.put("name", admin.getUsername());
      data.put("avatar", admin.getAvatar());
      Integer[] roleIds = admin.getRoleIds();
      Set<String> roles = roleService.queryByIds(roleIds);
      Set<String> permissions = permissionService.queryByRoleIds(roleIds);
      data.put("roles", roles);
      data.put("name", admin.getUsername());
      data.put("perms", permissions);
      data.put("avatar", admin.getAvatar());
    }
    vo.put("data", data);
    vo.put("errno", 0);
    vo.put("errmsg", "成功");
    return vo;
  }


  @RequestMapping("dashboard")
  @ResponseBody
  public Map dashboard() {
    HashMap<String, Object> vo = new HashMap<>();
    long goodsCount = goodsService.selectCount();
    long userCount = userService.slectCount();
    long productCount = productService.slectCount();
    long orderCount = orderService.slectCount();
    HashMap<String, Object> data = new HashMap<>();
    data.put("goodsTotal", goodsCount);
    data.put("userTotal", userCount);
    data.put("productTotal", productCount);
    data.put("orderTotal", orderCount);
    vo.put("errno", 0);
    vo.put("data", data);
    vo.put("errmsg", "成功");
    return vo;
  }


  @RequestMapping("/auth/logout")
  @ResponseBody
  public Map logout() {
    HashMap<String, Object> vo = new HashMap<>();
    Subject currentUser = SecurityUtils.getSubject();
      currentUser.logout();
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    return vo;
  }
  @RequestMapping("/auth/401")
  @ResponseBody
  public Map auth401() {
    HashMap<String, Object> vo = new HashMap<>();
    vo.put("errno", 501);
    vo.put("errmsg", "请登录");
    return vo;
  }
}
