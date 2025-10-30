package com.example.learning;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.classes.Month;
import com.example.learning.classes.Year;
import com.example.learning.adapter.YearAdapter;
import com.example.learning.data.BudgetData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface {

    RecyclerView yearRecycleView;
    ArrayList<Year>  years;
    ArrayList<Month>  months;
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

        // Present recycle view of the years
        yearRecycleView = findViewById(R.id.yearRecycleView);

        // Loading the data
        data = new BudgetData(this);
        years = data.getYearsList();
        months = data.getMonthsList();

        // setting into adapter
        YearAdapter yearAdapter = new YearAdapter(getApplicationContext(), R.layout.year, years, this);
        yearRecycleView.setLayoutManager(new LinearLayoutManager(this));
        yearRecycleView.setAdapter(yearAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Year selectedYear = years.get(position);

        Intent intent = new Intent(MainActivity.this, YearlyBudgetActivity.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("year", selectedYear);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}