package com.interview.app.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.interview.app.model.User;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> allList() {
        String sql = "select id, email, password, username, roles from users";
        return jdbcTemplate.query(sql, (rs, Index) -> new User(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("username"),
                rs.getString("roles")));
    }

    public User findById(Long id) {
        String sql = "select id, email, password, username, roles from users where id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, Index) -> new User(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("username"),
                rs.getString("roles")));
    }

    public int create(User user) {
        String sql = "insert into users (email, password, username, roles) value (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            user.getEmail(),
            user.getPassword(),
            user.getUsername(),
            user.getRoles()
        );
    }

    public int delete(long id){
        return jdbcTemplate.update("delete from users where id = ? ", id);
    }

}
