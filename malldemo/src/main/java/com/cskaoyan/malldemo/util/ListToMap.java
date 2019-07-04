package com.cskaoyan.malldemo.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class ListToMap {
    public static Map getMap(List list,int total){
        Map map1 = new HashMap();
        Map map2=new HashMap();
        map2.put("total",total);
        map2.put("items",list);
        map1.put("errno",0);
        map1.put("data",map2);
        map1.put("errmsg","成功");
        return map1;
    }

}
