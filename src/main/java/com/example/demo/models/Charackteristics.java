package com.example.demo.models;


import jakarta.persistence.*;

@Entity
public class Charackteristics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "goods_id")
    private Goods goods_id;
    private String name;
    private String result;

    public Charackteristics() {
    }


}
