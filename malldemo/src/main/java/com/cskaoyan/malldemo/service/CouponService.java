package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Coupon;

import java.util.List;

public interface CouponService {
    List<Coupon> findAllCoupon(int page, int limit, Coupon coupon);

    long CouponCount();

    int deleteCoupon(Coupon coupon);

    int insertCoupon(Coupon coupon);

    int updateCoupon(Coupon coupon);

    Coupon selectCouponById(int id);
}
