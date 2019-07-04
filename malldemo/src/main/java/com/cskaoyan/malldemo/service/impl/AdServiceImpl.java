package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Ad;
import com.cskaoyan.malldemo.bean.AdExample;
import com.cskaoyan.malldemo.mapper.AdMapper;
import com.cskaoyan.malldemo.service.AdService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    AdMapper adMapper;
    @Override
    public List<Ad> findAllAd(int page, int limit,Ad ad) {
        PageHelper.startPage(page,limit);
        List<Ad> allAd = adMapper.findAllAd(ad);
        return allAd;
    }

    @Override
    public long selectCount() {
        AdExample example = new AdExample();
        long count = adMapper.countByExample(example);
        return count;
    }

    @Override
    public int deleteAd(Ad ad) {
        int i = adMapper.deleteAd(ad);
        return i;
    }

    @Override
    public int insertAd(Ad ad) {
        int i = adMapper.insertAd(ad);
        return i;
    }

    @Override
    public int updateAd(Ad ad) {
        int i = adMapper.updateByPrimaryKeySelective(ad);
        return i;
    }
}
