package com.example.learning.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Month implements Serializable {
    public String month;
    public ArrayList<Category> income = new ArrayList<>();
    public ArrayList<Category> expenditure = new ArrayList<>();
    public ArrayList<Category> entertainment = new ArrayList<>();

    public Month(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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