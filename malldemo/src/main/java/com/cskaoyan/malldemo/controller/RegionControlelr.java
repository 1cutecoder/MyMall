package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.Region;
import com.cskaoyan.malldemo.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cute coder
 * 2019/5/22 21:35
 */
@Controller
@RequestMapping("region")
public class RegionControlelr {

  @Autowired
  RegionService regionService;

  @RequestMapping("list")
  @ResponseBody
  public Map list(){
    HashMap<Object, Object> map = new HashMap<>();
    List<Region> regions = regionService.selectAllRegion();
    if (regions !=null) {
      map.put("errno",0);
      map.put("data",regions);
      map.put("errmsg","成功");
    }
    return map;
  }
}
