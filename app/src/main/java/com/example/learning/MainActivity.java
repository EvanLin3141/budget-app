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


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView monthRecView;

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

        monthRecView = findViewById(R.id.monthRecView);

        ArrayList<Month> months = loadMonths();

        MonthAdapter adapter = new MonthAdapter();
        adapter.setMonths(months);

        monthRecView.setAdapter(adapter);
        monthRecView.setLayoutManager(new LinearLayoutManager(this));

    }

    public ArrayList<Month> loadMonths() {
        ArrayList<Month> months = new ArrayList<>();
        try {
            InputStream stream = getAssets().open("months.json");
            InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray monthArray = jsonObject.getAsJsonArray("months");
            Log.d("Test", "test");

            for (JsonElement element : monthArray) {
                JsonObject monthObj = element.getAsJsonObject();
                String name = monthObj.get("name").getAsString();
                months.add(new Month(name));
                Log.d("Months", name);

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return months;
    }
}