package com.example.simple_interest;

//package com.example.sqliteexample;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SqliteExample extends AppCompatActivity {

    EditText edtId, edtName, edtAddress;
    Button btnInsert, btnSelect, btnUpdate, btnDelete;
    TextView txtData;
    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_example);

        myDbHelper = new MyDbHelper(this);
        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnSelect = findViewById(R.id.btnSelect);
        btnDelete = findViewById(R.id.btnDelete);
        txtData = findViewById(R.id.txtData);

        btnInsert.setOnClickListener(view -> {
            int id = Integer.parseInt(edtId.getText().toString());
            String name = edtName.getText().toString();
            String address = edtAddress.getText().toString();
            myDbHelper.insertData(id, name, address);
            Toast.makeText(getApplicationContext(), "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
        });

        btnSelect.setOnClickListener(view -> {
            Cursor cursor = myDbHelper.selectData();
            StringBuilder data = new StringBuilder();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String address = cursor.getString(2);
                data.append("Id=").append(id)
                        .append("  Name=").append(name)
                        .append("  Address=").append(address)
                        .append("\n");
            }
            txtData.setText(data.toString());
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
