package com.cskaoyan.malldemo.util;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cute coder
 * 2019/6/16 17:36
 */

public class MyDateConverter implements Converter<String, Date> {
  @Override
  public Date convert(String source) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date = simpleDateFormat.parse(source);
      return date;
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }
}
