package com.bitsof.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

import javax.sql.DataSource;

public class DBConfig {
    private static HikariDataSource dataSource;

    static {
        String env = System.getenv("ENV") != null ? System.getenv("ENV") : "production";

        Dotenv dotenv = Dotenv.configure()
                .filename(".env." + env)
                .ignoreIfMissing()
                .load();

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dotenv.get("DB_URL"));
        config.setUsername(dotenv.get("DB_USERNAME"));
        config.setPassword(dotenv.get("DB_PASSWORD"));

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}