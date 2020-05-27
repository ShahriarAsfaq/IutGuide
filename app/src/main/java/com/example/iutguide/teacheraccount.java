package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class teacheraccount extends AppCompatActivity {
    Intent intent= getIntent();
    private Button Courses;
    private Button TeacherEvents;
    Button teacherAccountB4;
    private Button project;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacheraccount);

        project=findViewById(R.id.project);
        teacherAccountB4=(Button)findViewById(R.id.teacherAccountB4);
        teacherAccountB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(teacheraccount.this,QrCodeGenerator.class);
                startActivity(intent);
            }
        });
        TeacherEvents=(Button)findViewById(R.id.teacherevents);
        TeacherEvents.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(teacheraccount.this,Events.class);
                startActivity(intent);
            }
        });

        Courses=(Button)findViewById(R.id.courses);
        Courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(teacheraccount.this,Course.class);
                startActivity(intent);
            }
        });

        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
