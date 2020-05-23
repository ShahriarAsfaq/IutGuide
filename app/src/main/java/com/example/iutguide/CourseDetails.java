package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.Task;

public class CourseDetails extends AppCompatActivity {
    Intent intent= getIntent();
    Button attendence;
    Button resourses;
    Button tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        attendence=(Button)findViewById(R.id.button3);
        resourses=(Button)findViewById(R.id.button6);
        tasks=(Button)findViewById(R.id.button7);
        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseDetails.this, TasksTeacher.class);
                startActivity(intent);
            }
        });
        final Student_Course student_course=new Student_Course();


            attendence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(student_course.verify()==1) {
                        Intent intent=new Intent(CourseDetails.this,StudentAttendence.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent=new Intent(CourseDetails.this,Attendence.class);
                        startActivity(intent);
                    }
                }
            });

    }
}
