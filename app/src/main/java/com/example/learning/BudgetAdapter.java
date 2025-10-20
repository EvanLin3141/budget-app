package com.example.learning;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewHolder>{
    ArrayList<Budget> data = new ArrayList<>();
    ArrayList<String> years = new ArrayList<>();
    Context context;
    RecycleViewInterface recycleViewInterface;

    public BudgetAdapter(RecycleViewInterface recycleViewInterface) {
        this.context = context;
        this.recycleViewInterface = recycleViewInterface;
    }

    public void setData(ArrayList<Budget> budget) {
        this.data = budget;
        notifyDataSetChanged();
    }

    public void setYear(ArrayList<String> year) {
        this.years = year;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.year, parent, false);
        return new BudgetAdapter.ViewHolder(view, this.recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetAdapter.ViewHolder holder, int position) {
        holder.year.setText(data.get(position).getYear());
        String year = years.get(position);
        holder.year.setText(year);
        Log.d("Adapter111111111111111111", "Binding: " + year);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView year;

        public ViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);
            year = itemView.findViewById(R.id.year);

            itemView.setOnClickListener(v -> {
                if (recycleViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recycleViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }


}
