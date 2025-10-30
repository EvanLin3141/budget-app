package com.example.learning;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
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
    Button webUrlButton;
    private String weburl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_budget_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.budgetScrollView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtTitle = findViewById(R.id.txtTitle);
        tableLayout = findViewById(R.id.tableLayout);
        webUrlButton = findViewById(R.id.budget_button);

        Bundle bundle = getIntent().getExtras();

        weburl = "https://google.com";
        if (bundle != null) {
            String categoryType = bundle.getString("categoryType");

            // Get the right category for the right url link
            switch(categoryType) {
                case "Income":
                    weburl = "https://ie.indeed.com/career-advice/finding-a-job/side-hustle-ideas";
                    break;
                case "Expenditure":
                    weburl = "https://www.truist.com/money-mindset/principles/budgeting-by-values/reducing-your-expenses";
                    break;
                case "Entertainment":
                    weburl = "https://www.theguardian.com/thefilter/2025/feb/27/how-to-stop-impulse-buying";
                    break;
                default:
                    break;
            }

            ArrayList<Category> categoryData =
                    (ArrayList<Category>) bundle.getSerializable("categoryData");

            txtTitle.setText(categoryType + " Details");

            for (int i = 0; i < categoryData.size(); i++) {
                Category item = categoryData.get(i);

                TableRow row = new TableRow(this);


                // Column 1: Category Name
                TextView col1 = new TextView(this);
                col1.setText(item.getName());
                col1.setTextColor(Color.parseColor("#E0E0E0"));
                col1.setTextSize(18);
                col1.setPadding(24, 16, 24, 16);
                col1.setTypeface(Typeface.DEFAULT_BOLD);
                col1.setGravity(Gravity.START);
                col1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                // Column 2: Amount
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

        webUrlButton.setOnClickListener(v ->
        {
            Intent intent1 = new Intent(BudgetDetailsActivity.this, WebActivity.class);
            Bundle bundle1 = new Bundle();

            bundle1.putString("url", weburl);
            intent1.putExtras(bundle1);
            startActivity(intent1);
        });
    }

}
