package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    Intent intent = getIntent();
    private EditText Name;
    private EditText ID;
    private EditText Email;
    private EditText Department;
    private EditText Program;
    private Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Name = (EditText)findViewById(R.id.signUpName);
        ID = (EditText)findViewById(R.id.signUpID);
        Email = (EditText)findViewById(R.id.signUpEmail);
        Department = (EditText)findViewById(R.id.signUpDepartment);
        Program = (EditText)findViewById(R.id.signUpProgram);
        SignUp = (Button) findViewById(R.id.signUpButton);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
