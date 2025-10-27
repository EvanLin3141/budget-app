package com.example.learning.classes;

import java.io.Serializable;

public class Category implements Serializable {
    private String name;
    private int amount;

    public Category(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}