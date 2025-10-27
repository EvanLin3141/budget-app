package com.example.learning;

import android.content.Context;
import android.util.Log;

import com.example.learning.classes.Category;
import com.example.learning.classes.Month;
import com.example.learning.classes.Year;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class BudgetData {

    private ArrayList<Year> yearsList = new ArrayList<>();
    private ArrayList<Month> monthsList = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();


    public ArrayList<Year> getYearsList() {
        return yearsList;
    }

    public ArrayList<Month> getMonthsList() {
        return monthsList;
    }

    private Context context;

    public BudgetData(Context context) {
        this.context = context;
        Log.e("DATA", "IN PARSING NOW" );
        try {
            InputStream stream = context.getAssets().open("budget.json");
            InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            for (String yearKey : jsonObject.keySet()) {
                Year year = new Year(yearKey);
                JsonObject monthsObj = jsonObject.getAsJsonObject(yearKey);

                for (String monthKey : monthsObj.keySet()) {
                    Month month = new Month(monthKey);
                    JsonObject categoriesObj = monthsObj.getAsJsonObject(monthKey);

                    // Parse income
                    if (categoriesObj.has("income")) {
                        JsonArray incomeArray = categoriesObj.getAsJsonArray("income");
                        for (JsonElement e : incomeArray) {
                            JsonObject obj = e.getAsJsonObject();
                            month.income.add(new Category(
                                    obj.get("source").getAsString(),
                                    obj.get("amount").getAsInt()
                            ));
                        }
                    }

                    // Parse expenditure
                    if (categoriesObj.has("expenditure")) {
                        JsonArray expArray = categoriesObj.getAsJsonArray("expenditure");
                        for (JsonElement e : expArray) {
                            JsonObject obj = e.getAsJsonObject();
                            month.expenditure.add(new Category(
                                    obj.get("item").getAsString(),
                                    obj.get("amount").getAsInt()
                            ));
                        }
                    }

                    // Parse entertainment
                    if (categoriesObj.has("entertainment")) {
                        JsonArray entArray = categoriesObj.getAsJsonArray("entertainment");
                        for (JsonElement e : entArray) {
                            JsonObject obj = e.getAsJsonObject();
                            month.entertainment.add(new Category(
                                    obj.get("item").getAsString(),
                                    obj.get("amount").getAsInt()
                            ));
                        }
                    }

                    year.months.add(month);
                }

                yearsList.add(year);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


