package com.example.simple_interest;

//package com.example.sqliteexample;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SqliteExample1 extends AppCompatActivity {

    EditText edtId, edtName, edtAddress;
    Button btnInsert, btnSelect, btnUpdate, btnDelete;
    MyDbHelper1 myDbHelper;
    ListView listView;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.sqlite_example1);

        myDbHelper = new MyDbHelper1(this);

        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        listView = findViewById(R.id.mylist);

        btnInsert.setOnClickListener(view -> {
            int id = Integer.parseInt(edtId.getText().toString());
            String name = edtName.getText().toString();
            String address = edtAddress.getText().toString();
            myDbHelper.insertData(id, name, address);
            Toast.makeText(getApplicationContext(), "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
        });

        btnSelect.setOnClickListener(view -> {
            ArrayList<Integer> id = new ArrayList<>();
            ArrayList<String> name = new ArrayList<>();
            ArrayList<String> address = new ArrayList<>();

            Cursor cursor = myDbHelper.selectData();
            while (cursor.moveToNext()) {
                id.add(cursor.getInt(0));
                name.add(cursor.getString(1));
                address.add(cursor.getString(2));
            }

            ListAdapter adapter = new ListAdapter(SqliteExample1.this, id, name, address);
            listView.setAdapter(adapter);
        });

        btnUpdate.setOnClickListener(view -> {
            String id = edtId.getText().toString();
            String name = edtName.getText().toString();
            String address = edtAddress.getText().toString();
            myDbHelper.updateData(id, name, address);
            Toast.makeText(getApplicationContext(), "Data Updated Successfully!", Toast.LENGTH_SHORT).show();
        });

        btnDelete.setOnClickListener(view -> {
            String id = edtId.getText().toString();
            myDbHelper.deleteData(id);
            Toast.makeText(getApplicationContext(), "Data Deleted Successfully!", Toast.LENGTH_SHORT).show();
        });
    }
}
