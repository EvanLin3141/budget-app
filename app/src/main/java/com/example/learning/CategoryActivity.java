package com.example.learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.learning.classes.Category;
import com.example.learning.classes.Month;
import com.example.learning.classes.Year;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    Month selectedMonth;
    Year selectedYear;
    TextView txtTitle;
    LinearLayout categoryView;
    ArrayList<Category> selectedIncome;
    ArrayList<Category> selectedExpenditure;
    ArrayList<Category> selectedEntertainment;


    ArrayList<Month> months;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        categoryView = findViewById(R.id.category);
        selectedMonth = (Month)bundle.getSerializable("month");
        selectedYear = (Year)bundle.getSerializable("year");

        LinearLayout income = findViewById(R.id.incomeCard);
        LinearLayout expenditure = findViewById(R.id.expenditureCard);
        LinearLayout entertainment = findViewById(R.id.entertainmentCard);

        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(selectedMonth.getMonth() + selectedYear.getYear());


        selectedIncome = selectedMonth.getIncome();
        selectedExpenditure = selectedMonth.getExpenditure();
        selectedEntertainment = selectedMonth.getEntertainment();

        income.setOnClickListener(v -> openCategoryDetails("Income", selectedIncome));
        expenditure.setOnClickListener(v -> openCategoryDetails("Expenditure", selectedExpenditure));
        entertainment.setOnClickListener(v -> openCategoryDetails("Entertainment", selectedEntertainment));
    }

    private void openCategoryDetails(String categoryType, ArrayList<Category> data) {
        Intent intent = new Intent(CategoryActivity.this, BudgetDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("categoryType", categoryType);
        bundle.putSerializable("categoryData", data);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}