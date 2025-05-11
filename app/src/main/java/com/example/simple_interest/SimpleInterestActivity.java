package com.example.simple_interest;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SimpleInterestActivity extends AppCompatActivity {

    EditText editTextPrincipal, editTextRate, editTextTime;
    Button buttonCalculate;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);

        editTextPrincipal = findViewById(R.id.editTextPrincipal);
        editTextRate = findViewById(R.id.editTextRate);
        editTextTime = findViewById(R.id.editTextTime);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSimpleInterest();
            }
        });
    }
    private void calculateSimpleInterest() {
        String principalStr = editTextPrincipal.getText().toString();
        String rateStr = editTextRate.getText().toString();
        String timeStr = editTextTime.getText().toString();

        if (principalStr.isEmpty() || rateStr.isEmpty() || timeStr.isEmpty()) {
            textViewResult.setText("Please enter all values.");

            return;
        }
        float principal = Float.parseFloat(principalStr);
        float rate = Float.parseFloat(rateStr);
        float time = Float.parseFloat(timeStr);

        float simpleInterest = (principal * rate * time) / 100;
        textViewResult.setText("Simple Interest = " + simpleInterest);
    }
}