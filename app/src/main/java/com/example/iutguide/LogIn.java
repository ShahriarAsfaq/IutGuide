package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    Intent intent = getIntent();
    private Button login;
    private Button signup;
    private EditText name;
    private EditText password;
    private CheckBox remember_me;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_log_in);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        name=(EditText) findViewById(R.id.name);
        password=(EditText) findViewById(R.id.password);
        remember_me=(CheckBox)findViewById(R.id.rememberme);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup:
               Intent intent=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
               break;
            case R.id.login:
                loginApproval();
               break;
        }
    }

    private void loginApproval() {
        String email=name.getText().toString().trim();
        String password1=password.getText().toString().trim();


        mAuth.signInWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Intent intent=new Intent(getApplicationContext(),HomePage.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid email or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
