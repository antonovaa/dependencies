package com.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class StringListHandler extends BaseTypeHandler<List<String>> {
   @Override
   public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
      ps.setArray(i, ps.getConnection().createArrayOf("text", parameter.toArray(new String[parameter.size()])));
   }

   @Override
   public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
      throw new UnsupportedOperationException();
   }

   @Override
   public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
      throw new UnsupportedOperationException();
   }

   @Override
   public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
      throw new UnsupportedOperationException();
   }
}

