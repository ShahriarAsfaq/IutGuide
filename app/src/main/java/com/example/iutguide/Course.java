package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Course extends AppCompatActivity {
    Intent intent= getIntent();
    private Button coursedetails;
    private Button addCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        addCourse=(Button)findViewById(R.id.addCourse);
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Course.this,addCourse.class);
                startActivity(intent);
            }
        });
        coursedetails=(Button)findViewById(R.id.button5);
        coursedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(Course.this,CourseDetails.class);
                startActivity(in);
            }
        });
    }
}
