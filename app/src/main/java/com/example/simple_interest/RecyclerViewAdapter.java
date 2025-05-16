package com.example.simple_interest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Activity context;
    ArrayList<DataModel> data;

    public RecyclerViewAdapter(Activity context, ArrayList<DataModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.list_items1, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataModel current = data.get(position);
        holder.txtId.setText("ID: " + current.getId());
        holder.txtName.setText("Name: " + current.getName());
        holder.txtAddress.setText("Address: " + current.getAddress());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtName, txtAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtId);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }
    }
}
