package com.employee.apps.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.apps.model.User;

@Repository
public class UserDao {
    private final JdbcTemplate jdbc;

    public UserDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "select id, nama, email, password, status from users";

        return jdbc.query(sql, (rs, Num) -> new User(
                rs.getLong("id"),
                rs.getString("nama"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("status")));
    }

    public User findById(Long id) {
        String sql = "select id, nama, email, password, status from users where id = ?";
        return jdbc.queryForObject(sql, (rs, Num) -> new User(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("nama"),
                rs.getString("status")), id);
    }

    public int create(User user) {
        String sql = "insert into users (email, password, nama, status) values ( ? , ? , ? , ?)";
        return jdbc.update(sql,
                user.getEmail(),
                user.getPassword(),
                user.getNama(),
                user.getStatus());
    }

    public int update(User user) {
        String sql = "update user set email = ?, pasword = ?, nama = ?,  status = ? where id = ?";
        return jdbc.update(sql,
                user.getEmail(),
                user.getPassword(),
                user.getNama(),
                user.getStatus(),
                user.getId());
    }

    public int delete(Long id) {
        return jdbc.update("delete from user where id = ?", id);
    }

    public User findByEmail (String email){
         String sql = "select id, nama, email, password, status from users where email = ?";
         return jdbc.queryForObject(sql, (rs, index) -> new User(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("nama"),
                rs.getString("status")), email);
    }
}
