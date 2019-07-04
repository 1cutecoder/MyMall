package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Ad;

import java.util.List;

public interface AdService {
    List<Ad> findAllAd(int page, int limit, Ad ad);

    long selectCount();

    int deleteAd(Ad ad);

    int insertAd(Ad ad);

    int updateAd(Ad ad);
}
