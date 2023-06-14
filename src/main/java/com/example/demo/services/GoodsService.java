package com.example.demo.services;

import com.example.demo.models.Goods;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GoodsService extends CrudRepository<Goods, Integer>{
    //@Query("SELECT Count() from goods")
    //public int getCount();
}
