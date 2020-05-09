package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.pass);
        Button login = findViewById(R.id.login);

        final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String inputemail = email.getText().toString();
                final String inputpassword = password.getText().toString();
                if (TextUtils.isEmpty(inputemail)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputpassword)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                }
                else if (inputpassword.length() < 6) {
                    password.setError(getString(R.string.min_password));
                } else if(inputemail.equals("abc@gmail.com") && inputpassword.equals("12345678")) {
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, getString(R.string.authentication_failed), Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
