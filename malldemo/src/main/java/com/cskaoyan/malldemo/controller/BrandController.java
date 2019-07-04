package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Brand;
import com.cskaoyan.malldemo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by cute coder
 * 2019/5/23 9:04
 */
@Controller
@RequestMapping("brand")
public class BrandController {

  @Autowired
  BrandService brandService;

  @RequestMapping("list")
  @ResponseBody
  public Map list(int page, int limit, String sort, String order, Integer id,String name) {
    HashMap<String, Object> vo = new HashMap<>();
    HashMap<String, Object> data = new HashMap<>();
    List<Brand> brands = new LinkedList<>();
    if (id != null && id != 0) {
      Brand brand = brandService.selectById(id);
      brands.add(brand);
      data.put("total", 1);
      data.put("items", brands);
    } else if (name !=null) {
      brands = brandService.selectPageLikeName(name,page,limit,sort,order);
      data.put("total", 1);
      data.put("items", brands);
    }
    else {
      brands = brandService.selectPage(page, limit, sort, order);
      long total = brandService.slectCount();
      data.put("total", total);
      data.put("items", brands);
    }
    vo.put("data", data);
    vo.put("errno", 0);
    vo.put("errmsg", "成功");
    return vo;
  }

  @RequestMapping("create")
  @ResponseBody
  public Map create (@RequestBody Brand brand){
    HashMap<String, Object> vo = new HashMap<>();
    Date date = new Date();
    brand.setUpdateTime(date);
    brand.setAddTime(date);
    int insert = brandService.insert(brand);
    if (insert == 1) {
      vo.put("data", brand);
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }
  @RequestMapping("delete")
  @ResponseBody
  public Map delete (@RequestBody Brand brand){
    HashMap<String, Object> vo = new HashMap<>();
    brand.setUpdateTime(new Date());
    int delete = brandService.delete(brand);
    if (delete == 1) {
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }
  @RequestMapping("update")
  @ResponseBody
  public Map update (@RequestBody Brand brand){
    HashMap<String, Object> vo = new HashMap<>();
    Date date = new Date();
    brand.setUpdateTime(date);
    int update = brandService.update(brand);
    if (update == 1) {
      vo.put("data", brand);
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }

}
