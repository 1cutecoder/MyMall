package com.cskaoyan.malldemo.mapper;

import com.cskaoyan.malldemo.bean.Groupon;
import com.cskaoyan.malldemo.bean.Param;

import java.util.List;

public interface RecordMapper {

    List<Groupon> selectRecord(@org.apache.ibatis.annotations.Param("p") Param param,@org.apache.ibatis.annotations.Param("g") Groupon groupon);

}
