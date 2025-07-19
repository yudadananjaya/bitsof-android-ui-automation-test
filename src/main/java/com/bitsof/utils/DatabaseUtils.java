package com.bitsof.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Helper untuk convert column JSONB ke POJO
     */
    public static <T> T parseJsonColumn(ResultSet rs, String columnName, Class<T> targetClass) throws SQLException {
        String jsonString = rs.getString(columnName);
        if (jsonString == null) {
            return null;
        }

        try {
            return objectMapper.readValue(jsonString, targetClass);
        } catch (JsonProcessingException e) {
            throw new SQLException("Failed to parse JSON column: " + columnName, e);
        }
    }

    /**
     * Helper untuk close connection
     */
    public static void closeConnection(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
