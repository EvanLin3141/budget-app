package com.example.learning;

import android.content.Context;

public class Budget {
    Context context;
    private String year;
    private String month;
    private String category;

    public Budget (String year, String month, String category) {
        this.year = year;
        this.month = month;
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
