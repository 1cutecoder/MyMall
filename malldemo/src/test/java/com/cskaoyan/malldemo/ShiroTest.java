package com.cskaoyan.malldemo;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by cute coder
 * 2019/5/24 9:45
 */
public class ShiroTest {
    @Test
    public void shiro(){
      String s = UUID.randomUUID().toString().replace("-","");
      System.out.println(s);
    }
}
