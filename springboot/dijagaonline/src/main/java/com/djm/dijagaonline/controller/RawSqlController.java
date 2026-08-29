package com.djm.dijagaonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/raw")
public class RawSqlController {

    @Autowired
    private JdbcTemplate jdbc;

    @GetMapping("/users")
    public List<Map<String, Object>> usersRaw() {

        String sql = """
                    SELECT id, name, email, salt , password
                    FROM users
                    ORDER BY id DESC
                """;

        return jdbc.queryForList(sql);
    }

    @GetMapping("/users/{id}")
    public Map<String, Object> userDetail(@PathVariable Long id) {

        String sql = """
                    SELECT id, name, email, salt, password
                    FROM users
                    WHERE id = ?
                """;

        return jdbc.queryForMap(sql, id);
    }
}
