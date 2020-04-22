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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogIn extends AppCompatActivity {
    Intent intent = getIntent();
    private Button login;
    private Button signup;
    private EditText name;
    private EditText password;
    private CheckBox remember_me;
    private String SID;
    private FirebaseAuth mAuth;
    DatabaseReference studentId;
    protected static int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        studentId= FirebaseDatabase.getInstance().getReference("Student");
        mAuth = FirebaseAuth.getInstance();
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        name=(EditText) findViewById(R.id.name);
        password=(EditText) findViewById(R.id.password);
        remember_me=(CheckBox)findViewById(R.id.rememberme);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogIn.this,SignUp.class);
                startActivity(intent);
            }
        });
     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             loginApproval();

         }
     });
     remember_me.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             num=1;
         }
     });




    }



    private void loginApproval() {
        String email = name.getText().toString().trim();
        String password1 = password.getText().toString().trim();
        if (email.length()!=0 && password1.length()!=0) {
            mAuth.signInWithEmailAndPassword(email, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        SignUp singUp1=new SignUp();
                        if(singUp1.getCheck2()==3){
                            Intent intent3=new Intent(LogIn.this,StudentLogin.class);
                            startActivity(intent3);
                        }
                        else if(singUp1.getCheck1()==3){
                            Intent intent4=new Intent(LogIn.this,TeacherLogin.class);
                            startActivity(intent4);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Not recognised",Toast.LENGTH_LONG).show();
                        }
                    }
                     else {
                        Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
        else {
            Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
    int checkbox(){
       return num;
    }
}
