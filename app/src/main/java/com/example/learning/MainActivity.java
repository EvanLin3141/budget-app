package com.example.learning;

import android.os.Bundle;
import android.util.Log;



import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface{

    RecyclerView yearRecycleView;
    ArrayList<String> years;
    BudgetAdapter adapter;
    BudgetData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        yearRecycleView = findViewById(R.id.yearRecycleView);
        data = new BudgetData(this);
        ArrayList<Year> years = data.getYearsList();
        Log.d("MainActivity", "Years loaded: " + years.size());

        // setting into adapter
        YearAdapter yearAdapter = new YearAdapter(years, this);
        yearRecycleView.setLayoutManager(new LinearLayoutManager(this));
        yearRecycleView.setAdapter(yearAdapter);

    }

    @Override
    public void onItemClick(int position) {
    }
//    public ArrayList<String> loadYears() {
//        ArrayList<String> years = new ArrayList<>();
//        try {
//            InputStream stream = getAssets().open("budget.json");
//            InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
//            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
//
//            for (String yearKey : jsonObject.keySet()) {
//                years.add(yearKey);
//                Log.d("Year", "Loaded year: " + yearKey);
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return years;
//    }

//    public ArrayList<Month> loadMonths() {
//        ArrayList<Month> months = new ArrayList<>();
//        try {
//            InputStream stream = getAssets().open("budget.json");
//            InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
//            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
//            JsonArray monthArray = jsonObject.getAsJsonArray("months");
//
//            for (JsonElement element : monthArray) {
//                JsonObject monthObj = element.getAsJsonObject();
//                String name = monthObj.get("name").getAsString();
//                months.add(new Month(name));
//            }
//
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return months;
//    }
}