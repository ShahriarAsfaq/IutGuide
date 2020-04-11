package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    Intent intent = getIntent();
    private EditText Name;
    private EditText ID;
    private EditText Email;
    private EditText Department;
    private EditText Program;
    private EditText Password;
    private EditText contract;
    private Button SignUp;
    private FirebaseAuth mAuth;
    CheckBox Teachervarification;
    CheckBox StudentVarification;
    DatabaseReference teacherData;
    DatabaseReference studentData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        Name = (EditText)findViewById(R.id.signUpName);
        ID = (EditText)findViewById(R.id.signUpID);
        Department = (EditText)findViewById(R.id.signUpDepartment);
        Program = (EditText)findViewById(R.id.signUpProgram);
        Email = (EditText)findViewById(R.id.signUpEmail);
         Password = (EditText)findViewById(R.id.signupPassword);
         contract = (EditText)findViewById(R.id.signUpContract);
        SignUp = (Button) findViewById(R.id.signUpButton);
        Teachervarification=(CheckBox)findViewById(R.id.TeacherVarification);
        StudentVarification=(CheckBox)findViewById(R.id.StudentVarification);




        Teachervarification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= Name.getText().toString();
                String id= ID.getText().toString();
                String department= Department.getText().toString();
                String contracts= contract.getText().toString();
                String program= Program.getText().toString();

                teacherData=FirebaseDatabase.getInstance().getReference("Teacher");
                //teacherData.child("ID").setValue(id);
                teacherData.child(id).child("Name").setValue(name);
                teacherData.child(id).child("Department").setValue(department);
                teacherData.child(id).child("Contract").setValue(contracts);


            }
        });

        StudentVarification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= Name.getText().toString().trim();
                String id= ID.getText().toString().trim();
                String department= Department.getText().toString().trim();
                String contracts= contract.getText().toString().trim();
                String program= Program.getText().toString().trim();

                studentData=FirebaseDatabase.getInstance().getReference("Student");
                //studentData.child("ID").setValue(id);
                studentData.child(id).child("Name").setValue(name);
                studentData.child(id).child("Department").setValue(department);
                studentData.child(id).child("Program").setValue(program);
                studentData.child(id).child("Contract").setValue(contracts);

            }
        });


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            userRegister();
            }
        });
    }

    private void userRegister() {

        String email= Email.getText().toString().trim();
        String password= Password.getText().toString().trim();
        if(email.isEmpty()){
            Email.setError("Enter an Email address");
            Email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Enter a valid Email Address");
            Email.requestFocus();
        }
        if(password.isEmpty()){
            Password.setError("Enter an Email address");
            Password.requestFocus();
            return;
        }
        if(password.length()<6){
            Password.setError("Password has be of minimum 6 character");
            Password.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Registration complete",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignUp.this,LogIn.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"Registration is not successful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
