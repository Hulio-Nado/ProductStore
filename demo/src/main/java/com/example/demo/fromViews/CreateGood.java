package com.example.demo.fromViews;

public class CreateGood {
    private int id;
    private String name;
    private int price;

    public CreateGood() {
    }

    public CreateGood(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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
