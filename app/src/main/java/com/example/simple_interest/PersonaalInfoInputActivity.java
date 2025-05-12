package com.example.simple_interest;

//package com.example.personalinformationapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class PersonaalInfoInputActivity extends AppCompatActivity {
    EditText editTextName, editTextAddress, editTextPhone;
    RadioGroup radioGroupGender;
    Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_input);
        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);

        editTextPhone = findViewById(R.id.editTextPhone);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String address = editTextAddress.getText().toString();
            String phone = editTextPhone.getText().toString();
            int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
            RadioButton selectedGenderButton = findViewById(selectedGenderId);
            String gender = selectedGenderButton != null ? selectedGenderButton.getText().toString() : "Not Selected";
            Intent intent = new Intent(PersonaalInfoInputActivity.this, PersonalInfoDisplayActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("address", address);
            intent.putExtra("gender", gender);
            intent.putExtra("phone", phone);
            startActivity(intent);
        });
    }
}