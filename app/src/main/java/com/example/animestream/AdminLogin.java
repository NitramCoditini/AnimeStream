package com.example.animestream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText adEmail, adPassword;

    Button adLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


        adEmail = findViewById(R.id.adminEmail);
        adPassword = findViewById(R.id.adminPassword);
        adLogin = findViewById(R.id.adminLogin);

        adLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = adEmail.getText().toString();
                String pass = adPassword.getText().toString();

                // Replace with your own hardcoded values
                String validEmail = "martin.muiga47@gmail.com";
                String validPassword = "password123";

                if (email.equals(validEmail) && pass.equals(validPassword)) {
                    // Login successful
                    // You can start the main activity or perform any other actions.
                    Intent intent = new Intent(AdminLogin.this , AdminActivity.class);
                    startActivity(intent);
                    Toast.makeText(AdminLogin.this, "Login successful", Toast.LENGTH_SHORT).show();

                } else {
                    // Login failed
                    Toast.makeText(AdminLogin.this, "Login failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}