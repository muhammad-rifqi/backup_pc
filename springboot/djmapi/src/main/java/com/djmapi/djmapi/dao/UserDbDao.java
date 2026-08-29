package com.djmapi.djmapi.dao;

import com.djmapi.djmapi.model.UserDb;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDbDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDbDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserDb> findAll() {
        String sql = "SELECT id, email, username, password, access FROM users";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new UserDb(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("access")));
    }

    public UserDb findById(Long id) {
        String sql = "SELECT id, email, username, password, access FROM users WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new UserDb(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("access")),
                id);
    }

    public UserDb findByEmail(String email) {
        String sql = "SELECT id, email, username, password, access FROM users WHERE email = ?";

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new UserDb(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("access")),
                email);
    }

    public List<UserDb> search(String keyword) {
        String sql = "SELECT id, email, username, password, access " +
                "FROM users " +
                "WHERE username ILIKE ? OR email ILIKE ?";

        String param = "%" + keyword + "%";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new UserDb(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("access")),
                param, param);
    }
}
