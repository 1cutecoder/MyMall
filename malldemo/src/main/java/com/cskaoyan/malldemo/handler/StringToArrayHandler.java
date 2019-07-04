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
public class StringToArrayHandler extends BaseTypeHandler<String[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        for (String string : strings) {
            sb.append(string).append(",");
        }
        String substring = sb.substring(0,sb.length() - 1);
        if (substring!=null) {
            preparedStatement.setString(i, substring);
        }
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String[] split=null;
        if (s!=null) {
            String string = resultSet.getString(s);
            split = string.split(",");
        }

        return split;
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {

        String string = resultSet.getString(i);
        String[] split = null;
        if (string!=null) {
            split = string.split(",");
        }
        return split;
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        String[] split = null;
        if (string!=null) {
            split = string.split(",");
        }
        return split;
    }
}
