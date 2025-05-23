package com.example.simple_interest;



import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Mainactivity extends AppCompatActivity {

    Button btnShowAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertmessage); // links the layout file

        btnShowAlert = findViewById(R.id.btnShowAlert);

        btnShowAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("This is an alert message.");
        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss(); // close the dialog
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel(); // cancel the dialog
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}

