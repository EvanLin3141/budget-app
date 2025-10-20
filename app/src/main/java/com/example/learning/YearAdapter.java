package com.example.learning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YearAdapter extends RecyclerView.Adapter<YearAdapter.ViewHolder> {
    private ArrayList<Year> years;
    private RecycleViewInterface listener;

    public YearAdapter(ArrayList<Year> years, RecycleViewInterface listener) {
        this.years = years;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.year, parent, false);
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