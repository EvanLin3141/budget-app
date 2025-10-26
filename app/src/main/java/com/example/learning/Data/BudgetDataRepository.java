package com.example.learning.Data;

public class BudgetDataRepository {

    // ✅ Static variable that holds the data globally
    private static BudgetData data;

    // ✅ Static setter method
    public static void setData(BudgetData d) {
        data = d;
    }

    // ✅ Static getter method
    public static BudgetData getData() {
        return data;
    }
}
