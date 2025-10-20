package com.example.learning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder>{

    ArrayList<Month> months = new ArrayList<>();
    RecycleViewInterface recycleViewInterface;
    Context context;

    public MonthAdapter(RecycleViewInterface recyclerViewInterface) {
        this.context = context;
        this.recycleViewInterface = recycleViewInterface;
    }

    public void setMonths(ArrayList<Month> months) {
        this.months = months;
        notifyDataSetChanged(); // Update to new data
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.month.setText(months.get(position).getMonth());
    }

    @Override
    public int getItemCount() {
        return months.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.month, parent, false);

        return new MonthAdapter.ViewHolder(view, this.recycleViewInterface);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView month;
        public ViewHolder(@NonNull View itemView, RecycleViewInterface recyclerViewInterface) {
            super(itemView);
            month = itemView.findViewById(R.id.month);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            });
        }

    }

}

