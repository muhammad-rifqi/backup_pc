package com.employee.apps.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.apps.model.Role;
import java.util.List;

@Repository
public class RoleDao {
    private final JdbcTemplate jdbc;

    public RoleDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Role> allData() {
        return jdbc.query("select * from roles", (rs, Index) -> new Role(
                rs.getLong("id"),
                rs.getString("role_name"),
                rs.getString("description")));
    }

    public Role detailById(Long id) {
        return jdbc.queryForObject("select * from roles where id = ? ", (rs, Index) -> new Role(
                rs.getLong("id"),
                rs.getString("role_name"),
                rs.getString("description")), id);
    }

    public int create(Role role){
            String sql = "insert into role (role_name, description) values ( ? , ? )";
        return jdbc.update(sql,
                role.getRoleName(),
                role.getDescrition());
    }

}
