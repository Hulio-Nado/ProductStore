package com.example.demo.models;

import com.example.demo.fromViews.CreateGood;
import jakarta.persistence.*;

@Entity
public class Goods {
    public Goods() {
    }
    public Goods(CreateGood createGood) {
        this.name = createGood.getName();
        this.price = createGood.getPrice();
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
