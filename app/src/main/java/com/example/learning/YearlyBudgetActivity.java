package com.example.learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.adapter.MonthAdapter;
import com.example.learning.classes.Month;
import com.example.learning.classes.Year;

import java.util.ArrayList;

public class YearlyBudgetActivity extends AppCompatActivity implements RecycleViewInterface {

    RecyclerView monthRecycleView;
    Year selectedYear;
    TextView txtTitle;
    ArrayList<Month> months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.month_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // Present recycle view of the months
        monthRecycleView = findViewById(R.id.monthRecycleView);
        selectedYear= (Year)bundle.getSerializable("year");

        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(selectedYear.getYear() + " Budget");

        months = selectedYear.getMonths();

        // Setting data to the adapter
        RecyclerView monthRecycleView = findViewById(R.id.monthRecycleView);
        MonthAdapter monthAdapter = new MonthAdapter(getApplicationContext(), R.layout.month, months, this);
        monthRecycleView.setLayoutManager(new LinearLayoutManager(this));
        monthRecycleView.setAdapter(monthAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Month selectedMonth = months.get(position);

        Intent intent = new Intent(YearlyBudgetActivity.this, CategoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("month", selectedMonth);
        bundle.putSerializable("year", selectedYear);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}