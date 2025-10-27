package com.example.learning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.R;
import com.example.learning.RecycleViewInterface;
import com.example.learning.classes.Year;

import java.util.ArrayList;

public class YearAdapter extends RecyclerView.Adapter<YearAdapter.ViewHolder> {
    private ArrayList<Year> years;

    private RecycleViewInterface listener;
    Context context;
    int layout;



    public YearAdapter(Context context, int layout, ArrayList<Year> years, RecycleViewInterface listener) {
        this.context = context;
        this.years = years;
        this.listener = listener;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Year year = years.get(position);
        holder.yearText.setText(year.getYear());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return years.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView yearText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            yearText = itemView.findViewById(R.id.year);
        }
    }
}