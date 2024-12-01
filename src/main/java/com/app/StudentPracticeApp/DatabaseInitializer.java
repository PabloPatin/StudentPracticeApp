package com.app.StudentPracticeApp;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


//@Component
//public class DatabaseInitializer {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @PostConstruct
//    public void init() {
//        String scriptPath = "src/main/sql/init_triggers.sql";
//        try {
//            // Читаем SQL-скрипт из файла
//            String sqlScript = new String(Files.readAllBytes(Paths.get(new URI(scriptPath))));
//
//            // Выполняем SQL-скрипт с триггерами
//            jdbcTemplate.execute(sqlScript);
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//            // Обработать ошибку
//        }
//    }
//}
