package com.example.learning.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.Calendar.Month;
import com.example.learning.R;
import com.example.learning.RecycleViewInterface;
import com.example.learning.Calendar.Year;

import java.util.ArrayList;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder>{

    private ArrayList<Month> months;

    private RecycleViewInterface listener;
    Context context;
    int layout;

    public MonthAdapter(Context context, int layout, ArrayList<Month> months, RecycleViewInterface listener) {
        this.context = context;
        this.months = months;
        this.listener = listener;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);
        return new MonthAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Month month = months.get(position);
        holder.monthText.setText(month.getMonth());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return months.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView monthText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            monthText = itemView.findViewById(R.id.month);
        }
    }
}
