package com.example.simple_interest;
//package com.example.sqliteexample;

import android.app.Activity;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String> {

    Activity context;
    ArrayList<Integer> id;
    ArrayList<String> name;
    ArrayList<String> address;

    public ListAdapter(Activity context, ArrayList<Integer> id, ArrayList<String> name, ArrayList<String> address) {
        super(context, R.layout.list_items, name);
        this.context = context;
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_items, null, true);

        TextView txtId = rowView.findViewById(R.id.txtId);
        TextView txtName = rowView.findViewById(R.id.txtName);
        TextView txtAddress = rowView.findViewById(R.id.txtAddress);

        txtId.setText(String.valueOf(id.get(position)));
        txtName.setText(name.get(position));
        txtAddress.setText(address.get(position));

        return rowView;
    }
}

