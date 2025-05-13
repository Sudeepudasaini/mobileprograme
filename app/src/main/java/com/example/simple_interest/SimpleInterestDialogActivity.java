package com.example.simple_interest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

public class SimpleInterestDialogActivity extends AppCompatActivity {
    Button btnOpenDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest_dialog);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        btnOpenDialog.setOnClickListener(view -> showDialog());
    }
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_simple_interest, null);
        builder.setView(dialogView);
        EditText editPrincipal = dialogView.findViewById(R.id.editPrincipal);
        EditText editRate = dialogView.findViewById(R.id.editRate);
        EditText editTime = dialogView.findViewById(R.id.editTime);
        Button btnCalculate = dialogView.findViewById(R.id.btnCalculate);
        TextView txtResult = dialogView.findViewById(R.id.txtResult);
        AlertDialog dialog = builder.create();
        dialog.show();

        btnCalculate.setOnClickListener(v -> {
            try {
                double p = Double.parseDouble(editPrincipal.getText().toString());
                double r = Double.parseDouble(editRate.getText().toString());
                double t = Double.parseDouble(editTime.getText().toString());
                double si = (p * r * t) / 100;
                txtResult.setText("Simple Interest: " + si);
            } catch (Exception e) {
                txtResult.setText("Please enter valid numbers.");
            }
        });
    }
}
