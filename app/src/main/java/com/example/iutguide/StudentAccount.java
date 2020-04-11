package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentAccount extends AppCompatActivity {
    Intent intent= getIntent();
    private Button classes;
    private Button activity;
    private Button drive;
    private Button library;
    private Button event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
