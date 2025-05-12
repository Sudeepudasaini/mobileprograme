package com.example.simple_interest;

//package com.example.personalinformationapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class PersonalInfoDisplayActivity extends AppCompatActivity {
    TextView textViewDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_display);

        textViewDisplay = findViewById(R.id.textViewDisplay);

        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String gender = getIntent().getStringExtra("gender");
        String phone = getIntent().getStringExtra("phone");
        String result = "Name: " + name +
                "\nAddress: " + address +
                "\nGender: " + gender +
                "\nPhone: " + phone;
        textViewDisplay.setText(result);
    }
}