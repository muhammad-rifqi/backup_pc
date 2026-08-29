package com.webapp.app.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.webapp.app.model.User;

@Repository
public class UserDao {

    private final JdbcTemplate jdbc;

    public UserDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "select id, email, password , username , roles from users";
        return jdbc.query(sql, (rs, Index) -> new User(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("username"),
                rs.getString("roles")));
    }

    public User findById(Long id) {
        String sql = "select id, email, password , username , roles from users where id = ? ";
        return jdbc.queryForObject(sql, (rs, Index) -> new User(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("username"),
                rs.getString("username")));
    }

    public int create(User user){
        String sql = "insert into users (email, password, username, roles) values (?, ?, ?, ?)";
        return jdbc.update(sql, user.getEmail(),user.getPassword(), user.getUsername(), user.getRoles());
    }

     public int delete(Long id) {
        return jdbc.update("delete from users where id = ?", id);
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
