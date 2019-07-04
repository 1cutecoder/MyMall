package com.cskaoyan.malldemo.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.cskaoyan.malldemo.bean.Storage;
import com.cskaoyan.malldemo.service.StorageService;
import com.cskaoyan.malldemo.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by cute coder
 * 2019/5/23 16:23
 * url路径：Bucket名称.Endpoint/Object名称
 */
@Controller
@RequestMapping("storage")
public class StorageController {
  @Autowired
  StorageService storageService;


  @RequestMapping("create")
  @ResponseBody
  public Map storageCreate (MultipartFile file,HttpServletRequest request) throws IOException {
    HashMap<String, Object> vo = new HashMap<>();
    InputStream inputStream = file.getInputStream();
    String originalFilename = file.getOriginalFilename();
    String contentType = file.getContentType();
    long size = file.getSize();
    ObjectMetadata objectMetadata = new ObjectMetadata();
    objectMetadata.setContentType(contentType);
    objectMetadata.setContentLength(size);
    String key = UUID.randomUUID().toString().replace("-","");
    String endpoint ="oss-cn-hangzhou.aliyuncs.com";
    String accessKeyId = "LTAI51e4eZN7Xq11";
    String secretAccessKey = "nfIy9fZMOxLGj15E6MXEV78bjugFgG";
    String buckName="cskanyanmall-file";
    OSSClient ossClient = null;
    try {
      PutObjectRequest putObjectRequest = new PutObjectRequest(buckName,key,inputStream,objectMetadata);
      ossClient = new OSSClient(endpoint,accessKeyId,secretAccessKey);
      PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
    } catch (OSSException e) {
      e.printStackTrace();
    } catch (ClientException e) {
      e.printStackTrace();
    }finally {
        ossClient.shutdown();
    }
    String fileUrl = "http://cskanyanmall-file"+"."+endpoint+"/"+key;
    Storage storage = new Storage();
    Date date = new Date();
    storage.setUpdateTime(date);
    storage.setKey(key);
    storage.setName(originalFilename);
    storage.setSize((int)size);
    storage.setType(contentType);
    storage.setAddTime(date);
    storage.setUrl(fileUrl);
    int insert = storageService.insert(storage);
    if (insert == 1) {
      Storage selectStorage=storageService.selectByKey(key);
      vo.put("data",selectStorage);
      vo.put("errno", 0);
      vo.put("errmsg", "成功");
    }
    return vo;
  }
}
