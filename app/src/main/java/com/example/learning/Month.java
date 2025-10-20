package com.example.learning;

import java.util.ArrayList;

public class Month {
    public String monthName;
    public ArrayList<Category> income = new ArrayList<>();
    public ArrayList<Category> expenditure = new ArrayList<>();
    public ArrayList<Category> entertainment = new ArrayList<>();

    public Month(String monthName) {
        this.monthName = monthName;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public ArrayList<Category> getIncome() {
        return income;
    }

    public void setIncome(ArrayList<Category> income) {
        this.income = income;
    }

    public ArrayList<Category> getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(ArrayList<Category> expenditure) {
        this.expenditure = expenditure;
    }

    public ArrayList<Category> getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(ArrayList<Category> entertainment) {
        this.entertainment = entertainment;
    }
}