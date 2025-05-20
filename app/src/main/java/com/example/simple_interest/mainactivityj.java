package com.example.simple_interest;

//package com.example.multiplyapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class mainactivityj extends AppCompatActivity {

    EditText number1, number2;
    Button multiplyButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        multiplyButton = findViewById(R.id.multiplyButton);
        resultText = findViewById(R.id.resultText);

        multiplyButton.setOnClickListener(v -> {
            String input1 = number1.getText().toString().trim();
            String input2 = number2.getText().toString().trim();

            if (input1.isEmpty() || input2.isEmpty()) {
                Toast.makeText(mainactivityj.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int num1 = Integer.parseInt(input1);
                int num2 = Integer.parseInt(input2);
                int result = num1 * num2;
                resultText.setText("Result: " + result);
            } catch (NumberFormatException e) {
                Toast.makeText(mainactivityj.this, "Invalid input", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
