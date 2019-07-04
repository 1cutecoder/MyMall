package com.cskaoyan.malldemo.service.impl;

import com.cskaoyan.malldemo.bean.Storage;
import com.cskaoyan.malldemo.mapper.StorageMapper;
import com.cskaoyan.malldemo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cute coder
 * 2019/5/23 16:26
 */
@Service
public class StorageServiceImpl implements StorageService {
  @Autowired
  StorageMapper storageMapper;
  @Override
  public int insert(Storage storage) {
    int insertSelective = storageMapper.insertSelective(storage);
    return insertSelective;
  }

  @Override
  public Storage selectByKey(String key) {
   Storage storage = storageMapper.selectByKey(key);
    return storage;
  }
}
