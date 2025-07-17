package com.example.my_blog;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogSql {
    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void control(){
        jdbcTemplate.execute("INSERT INTO article (title, content) VALUES ('제목 1','내용 1')");
        jdbcTemplate.execute("INSERT INTO article (title, content) VALUES ('제목 2','내용 2')");
        jdbcTemplate.execute("INSERT INTO article (title, content) VALUES ('제목 3','내용 3')");
    }

}
