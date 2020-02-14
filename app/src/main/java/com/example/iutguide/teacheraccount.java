package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class teacheraccount extends AppCompatActivity {
    Intent intent= getIntent();
    private Button Courses;
    private Button TeacherEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacheraccount);

        TeacherEvents.findViewById(R.id.teacherEvents);
        TeacherEvents.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(teacheraccount.this,Events.class);
                startActivity(intent);
            }
        });

        Courses.findViewById(R.id.courses);
        Courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(teacheraccount.this,Course.class);
                startActivity(intent);
            }
        });
    }
}
