package com.example.demo2.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgressDatasource {

  @Bean
  public HikariDataSource hikariDataSource() {
    // HikariCPの初期化
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl("jdbc:postgresql://localhost:5432/demodb");
    config.setUsername("postgres");
    config.setPassword("password");
    return new HikariDataSource(config);
  }
}
// 1:31