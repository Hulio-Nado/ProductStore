package com.example.demo.services;

import com.example.demo.config.PostgresConfig;
import com.example.demo.mappers.GoodsMapper;
import com.example.demo.models.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsJDBCService {
    @Autowired
    PostgresConfig postgresConfig;

    public List<Goods> getAll(){
        var connection = new JdbcTemplate(postgresConfig.getDataSource());
        var query = connection.query("select * from goods", new GoodsMapper());
        return query;
    }

    public Goods getById(int id){
        var connection = new JdbcTemplate(postgresConfig.getDataSource());
        var query = connection.queryForObject("select * from goods where id="+id, new GoodsMapper());
        return query;
    }
}
