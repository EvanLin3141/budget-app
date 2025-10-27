package com.example.learning;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.learning.classes.Category;

import java.util.ArrayList;

public class BudgetDetailsActivity extends AppCompatActivity {

    TextView txtTitle;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_budget_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtTitle = findViewById(R.id.txtTitle);
        tableLayout = findViewById(R.id.tableLayout);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String categoryType = bundle.getString("categoryType");
            ArrayList<Category> categoryData =
                    (ArrayList<Category>) bundle.getSerializable("categoryData");

            txtTitle.setText(categoryType + " Details");


            // build text content from categoryData
            StringBuilder sourcesBuilder = new StringBuilder();
            StringBuilder amountsBuilder = new StringBuilder();

            for (int i = 0; i < categoryData.size(); i++) {
                Category item = categoryData.get(i);

                TableRow row = new TableRow(this);
                row.setPadding(0, 4, 0, 4); // small vertical spacing

                // Alternate row background color (zebra effect)
                if (i % 2 == 0) {
                    row.setBackgroundColor(Color.parseColor("#1E1E1E"));
                } else {
                    row.setBackgroundColor(Color.parseColor("#2A2A2A"));
                }

                // ===== Column 1: Category Name =====
                TextView col1 = new TextView(this);
                col1.setText(item.getName());
                col1.setTextColor(Color.parseColor("#E0E0E0"));
                col1.setTextSize(18);
                col1.setPadding(24, 16, 24, 16);
                col1.setTypeface(Typeface.DEFAULT_BOLD);
                col1.setGravity(Gravity.START);
                col1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                // ===== Column 2: Amount =====
                TextView col2 = new TextView(this);
                col2.setText("$" + item.getAmount());
                col2.setTextColor(Color.WHITE);
                col2.setTextSize(18);
                col2.setPadding(24, 16, 24, 16);
                col2.setGravity(Gravity.END);
                col2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                // Add both columns to row
                row.addView(col1);
                row.addView(col2);

                // Add row to table
                tableLayout.addView(row);
            }
        }

    }

}
