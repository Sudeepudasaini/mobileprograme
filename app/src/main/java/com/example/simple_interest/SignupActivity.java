package com.example.simple_interest;

//package com.example.signupform;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SignupActivity extends AppCompatActivity {
    EditText editTextUsername, editTextEmail;
    RadioGroup radioGroupGender;
    CheckBox checkBoxReading, checkBoxTraveling, checkBoxGaming;
    Spinner spinnerCity;
    Button buttonSubmit;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxReading = findViewById(R.id.checkBoxReading);
        checkBoxTraveling = findViewById(R.id.checkBoxTraveling);
        checkBoxGaming = findViewById(R.id.checkBoxGaming);
        spinnerCity = findViewById(R.id.spinnerCity);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        textViewResult = findViewById(R.id.textViewResult);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.city_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapter);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInputData();
            }
        });
    }

    private void displayInputData() {
        String username = editTextUsername.getText().toString();
        String email = editTextEmail.getText().toString();

        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton selectedGenderButton = findViewById(selectedGenderId);
        String gender = selectedGenderButton != null ? selectedGenderButton.getText().toString() : "Not Selected";
        String hobbies = "";
        if (checkBoxReading.isChecked()) hobbies += "Reading ";
        if (checkBoxTraveling.isChecked()) hobbies += "Traveling ";
        if (checkBoxGaming.isChecked()) hobbies += "Gaming ";

        String city = spinnerCity.getSelectedItem().toString();

        String result = "Username: " + username +

                "\nEmail: " + email +
                "\nGender: " + gender +
                "\nHobbies: " + hobbies +
                "\nCity: " + city;
        textViewResult.setText(result);
    }
}