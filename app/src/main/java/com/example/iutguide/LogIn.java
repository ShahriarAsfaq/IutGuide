package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {
    Intent intent = getIntent();
    private Button login;
    private Button signup;
    private EditText name;
    private EditText password;
    private CheckBox remember_me;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        name=(EditText) findViewById(R.id.name);
        password=(EditText) findViewById(R.id.password);
        remember_me=(CheckBox)findViewById(R.id.rememberme);

    }
}
