package com.cskaoyan.malldemo.service;

import com.cskaoyan.malldemo.bean.Storage;

/**
 * Created by cute coder
 * 2019/5/23 16:26
 */
public interface StorageService {
  int insert(Storage storage);

  Storage selectByKey(String key);
}
