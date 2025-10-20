package com.example.learning;

import java.util.ArrayList;

public class Year {
    public String year;
    public ArrayList<Month> months = new ArrayList<>();

    public Year(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}