package com.example.simple_interest;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import java.util.ArrayList;

public class SqliteExample2 extends AppCompatActivity {
    EditText edtId, edtName, edtAddress;
    Button btnInsert, btnSelect, btnUpdate, btnDelete;
    MyDbHelper myDbHelper;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_sqlite_example);

        myDbHelper = new MyDbHelper(this);
        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        recyclerView = findViewById(R.id.recyclerview);

        btnInsert.setOnClickListener(view -> {
            int id = Integer.parseInt(edtId.getText().toString());
            String name = edtName.getText().toString();
            String address = edtAddress.getText().toString();
            myDbHelper.insertData(id, name, address);
            Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
        });

        btnSelect.setOnClickListener(view -> {
            ArrayList<DataModel> data = new ArrayList<>();
            Cursor cursor = myDbHelper.selectData();
            while (cursor.moveToNext()) {
                data.add(new DataModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerViewAdapter = new RecyclerViewAdapter(this, data);
            recyclerView.setAdapter(recyclerViewAdapter);
        });

        btnUpdate.setOnClickListener(view -> {
            String id = edtId.getText().toString();
            String name = edtName.getText().toString();
            String address = edtAddress.getText().toString();
            myDbHelper.updateData(id, name, address);
            Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
        });

        btnDelete.setOnClickListener(view -> {
            String id = edtId.getText().toString();
            myDbHelper.deleteData(id);
            Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
        });
    }
}
