package com.example.demo.mappers;

import com.example.demo.models.Goods;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsMapper implements RowMapper<Goods> {
    @Override
    public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
        Goods good = new Goods();
        good.setId(rs.getInt("id"));
        good.setName(rs.getString("name"));
        good.setPrice(rs.getInt("price"));
        return good;
    }
}
