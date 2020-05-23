package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentAccount extends AppCompatActivity {
    Intent intent= getIntent();
    private Button studentCourse;
    private Button classes;
    private Button activity;
    private Button drive;
    private Button library;
    private Button event;
    public String SID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogIn login=new LogIn();
        SID=login.StudentId();
        studentCourse=findViewById(R.id.Studentb6);
        studentCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentAccount.this,Student_Batch.class);
                startActivity(intent);
            }
        });
        classes=(Button)findViewById(R.id.classes);
        activity=(Button)findViewById(R.id.activities);
        drive=(Button)findViewById(R.id.drive);
        library=(Button)findViewById(R.id.library);
        event=(Button)findViewById(R.id.event);
        classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentAccount.this,Classes.class);
                startActivity(intent);
            }
        });
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentAccount.this,Activities.class);
                startActivity(intent);
            }
        });
        drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentAccount.this,GoogleDrive.class);
                startActivity(intent);
            }
        });
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentAccount.this,Library.class);
                startActivity(intent);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentAccount.this,Events.class);
                startActivity(intent);
            }
        });

    }
}
