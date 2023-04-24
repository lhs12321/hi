package kr.mjc.lhs.basics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}