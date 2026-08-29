package com.djmapi.djmapi.dao;

import com.djmapi.djmapi.model.Tenant;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TenantDao {

    private final JdbcTemplate jdbcTemplate;

    public TenantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Tenant> findAll() {
        String sql = "SELECT id, name, domain, address FROM tenant";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new Tenant(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("domain"),
                rs.getString("address")));
    }

    public Tenant findById(Long id) {
        String sql = "SELECT id, name, domain, address FROM tenant WHERE id = ?";
        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new Tenant(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("domain"),
                        rs.getString("address")),
                id);
    }

    public int insert(Tenant tenant) {
        String sql = "INSERT INTO tenant(name, domain, address) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                tenant.getName(),
                tenant.getDomain(),
                tenant.getAddress());
    }

    public int update(Tenant tenant) {
        String sql = "UPDATE tenant set name = ? , domain = ? , address = ? where id = ?";
        return jdbcTemplate.update(
                sql,
                tenant.getName(),
                tenant.getDomain(),
                tenant.getAddress(),
                tenant.getId());
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM tenant WHERE id=?", id);
    }

    public List<Tenant> findAllPagination(int page, int size) {
        int offset = page * size;
        String sql = "SELECT id, name, domain, address FROM tenant ORDER BY id LIMIT ? OFFSET ?";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Tenant(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("domain"),
                        rs.getString("address")),
                size,
                offset);
    }

    
    public long countAll() {
        String sql = "SELECT COUNT(*) FROM tenant";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

}
