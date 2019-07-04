package com.cskaoyan.malldemo.util;

/**
 * Created by cute coder
 * 2019/5/24 9:02
 */
public class StringToArrayUtil {
    public static String[] getArray (String s){
      String[] split = null;
      String substring = null;
      if (s.contains("[")) {
        substring = s.substring(1, s.length() - 1);
      }
      if (substring.contains(",")) {
        split = s.split(",");
      } else if (s.contains("，")) {
        split = s.split("，");
      }
      return split;
    }
}
