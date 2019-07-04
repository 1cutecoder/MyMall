package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Region;
import com.cskaoyan.malldemo.bean.RegionExample;
import com.cskaoyan.malldemo.mapper.RegionMapper;
import com.cskaoyan.malldemo.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/22 21:36
 */
@Service
public class RegionServiceImpl implements RegionService {

  @Autowired
  RegionMapper regionMapper;

  @Override
  public List<Region> selectAllRegion() {
    RegionExample regionExample = new RegionExample();
    RegionExample.Criteria criteria = regionExample.createCriteria();
    criteria.andPidEqualTo(0);
    List<Region> regions = regionMapper.selectByExample(regionExample);
    return regions;
  }
}
