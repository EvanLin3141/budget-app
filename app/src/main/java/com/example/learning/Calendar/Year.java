package com.example.learning.Calendar;

import java.io.Serializable;
import java.util.ArrayList;

public class Year implements Serializable {
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

    public ArrayList<Month> getMonths() {
        return months;
    }

    @Override
    public String toString() {
        return year;
    }
}