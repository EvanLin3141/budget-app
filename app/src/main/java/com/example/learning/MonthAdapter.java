package com.example.learning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder>{

    private ArrayList<Month> months = new ArrayList<>();

    public MonthAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.month, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.month.setText(months.get(position).getMonth());
    }

    @Override
    public int getItemCount() {
        return months.size();
    }

    public void setMonths(ArrayList<Month> months) {
        this.months = months;
        notifyDataSetChanged(); // Update to new data
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView month;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            month = itemView.findViewById(R.id.month);
        }
    }

}
