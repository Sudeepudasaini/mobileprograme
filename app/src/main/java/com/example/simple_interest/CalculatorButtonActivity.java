package com.example.simple_interest;

//package com.example.calculatorapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class CalculatorButtonActivity extends AppCompatActivity {
    EditText editTextNumber1, editTextNumber2;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_button);

        editTextNumber1 = findViewById(R.id.editTextNumber1);

        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        textViewResult = findViewById(R.id.textViewResult);

        buttonAdd.setOnClickListener(v -> calculate('+'));
        buttonSubtract.setOnClickListener(v -> calculate('-'));
        buttonMultiply.setOnClickListener(v -> calculate('*'));
        buttonDivide.setOnClickListener(v -> calculate('/'));
    }
    private void calculate(char operator) {
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            textViewResult.setText("Please enter both numbers");
            return;
        }
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    textViewResult.setText("Cannot divide by zero");

                    return;
                } else {
                    result = num1 / num2;
                }
                break;
        }

        textViewResult.setText("Result: " + result);
    }
}