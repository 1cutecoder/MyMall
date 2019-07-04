package com.cskaoyan.malldemo.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cute coder
 * 2019/5/23 20:22
 */
public class StringToArraryHandler2 extends BaseTypeHandler<String[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(strings[0]);
        for(int j = 1; j < strings.length; j++ ) {
            sb.append(",").append(strings[j]);
        }
        sb.append("]");
        String substring = sb.substring(0,sb.length());
        preparedStatement.setString(i, substring);
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String str = resultSet.getString(s);
        String substring = str.substring(1,str.length()-1);
        String[] split = null;
        if (substring != null) {
            split = substring.split(",");
        }
        return split;
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String str = resultSet.getString(i);
        String substring = str.substring(1,str.length()-1);
        String[] split = null;
        if (substring != null) {
            split = substring.split(",");
        }
        return split;
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        String substring = string.substring(1,string.length()-1);
        String[] split = null;
        if (substring != null) {
            split = substring.split(",");
        }
        return split;
    }
}
