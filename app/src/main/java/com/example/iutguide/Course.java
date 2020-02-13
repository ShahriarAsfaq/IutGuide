package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Course extends AppCompatActivity {
    Intent intent= getIntent();
    private Button coursedetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
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
