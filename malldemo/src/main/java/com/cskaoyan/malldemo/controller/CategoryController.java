package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Category;
import com.cskaoyan.malldemo.service.CategoryService;
import com.cskaoyan.malldemo.util.StringToArrayUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by cute coder
 * 2019/5/23 16:45
 */

@Controller
@RequestMapping("category")
public class CategoryController {
  @Autowired
  CategoryService categoryService;


  @RequestMapping("list")
  @ResponseBody
  public Map list() {
    Map vo = new HashMap<>();
    List<Category> categories = categoryService.selectAll();
    if (categories != null) {
      vo.put("errno", 0);
      vo.put("data", categories);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

  @RequestMapping("l1")
  @ResponseBody
  public Map l1() {
    Map vo = new HashMap<>();
    List<Category> categories = null;
    categories = categoryService.selectFirstAll();
    LinkedList<Object> data = new LinkedList<>();
    HashMap<String, Object> children = null;
    if (categories != null) {
      for (Category category : categories) {
        children = new HashMap<>();
        children.put("value", category.getId());
        children.put("label", category.getName());
        data.add(children);
      }
      vo.put("errno", 0);
      vo.put("data", data);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

  @RequestMapping("update")
  @ResponseBody
  public Map update(@RequestBody Category category) throws InvocationTargetException, IllegalAccessException {
    Map vo = new HashMap<>();
    /*Category category = new Category();
    json.put("children", null);
    jsonMapToBean(category, json);*/
    Date date = new Date();
    category.setUpdateTime(date);
    int update = categoryService.update(category);
    if (update == 1) {
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

  @RequestMapping("create")
  @ResponseBody
  public Map create(@RequestBody Map<String, Object> json) throws InvocationTargetException, IllegalAccessException {
    Map vo = new HashMap<>();
    Category category = new Category();
    jsonMapToBean(category, json);
    Date date = new Date();
    category.setUpdateTime(date);
    category.setAddTime(date);
    category.setDeleted(false);
    int insert = categoryService.insert(category);
    if (insert == 1) {
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }


  @RequestMapping("delete")
  @ResponseBody
  public Map delete(@RequestBody Category category) {
    Map vo = new HashMap<>();
    int delete = categoryService.delete(category);
    if (delete == 1) {
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

  private void jsonMapToBean(Category category, Map<String, Object> json) {
    Object o = json.get("keywords");
    if (o instanceof List) {
      List list = (List) o;
      String[] array = new String[list.size()];
      for (int i = 0; i < list.size(); i++) {
        array[i] = (String) list.get(i);
        json.put("keywords", array);
      }
    }
    if (o instanceof String) {
      String[] array = StringToArrayUtil.getArray((String) o);
      json.put("keywords", array);
    }
    try {
      json.put("children",null);
      BeanUtils.populate(category, json);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}

