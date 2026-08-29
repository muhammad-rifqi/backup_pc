package com.employee.apps.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.apps.model.Menu;

@Repository
public class MenuDao {

    private final JdbcTemplate jdbc;

    public MenuDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Menu> menuall() {
        String sql = "select id, name, role_id, url from menu1";
        return jdbc.query(sql, (rs, Index) -> new Menu(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getLong("role_id"),
                rs.getString("url")));
    }

    public Menu findById(Long id) {
        String sql = "select id, name, role_id, url from menu1 where id = ?";
        return jdbc.queryForObject(sql, (rs, Index) -> new Menu(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getLong("role_id"),
                rs.getString("url")), id);
    }

    public int create(Menu menu) {
        String sql = "insert into menu(name, role_id,url) values (?,?,?)";
        return jdbc.update(sql, menu.getName(), menu.getRoleId(), menu.getUrl());

    }

}
