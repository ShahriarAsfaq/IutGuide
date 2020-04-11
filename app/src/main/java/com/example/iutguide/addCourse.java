package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addCourse extends AppCompatActivity {
    Intent intent= getIntent();
    DatabaseReference databaseReference;
    private EditText addCourseET1;
    private EditText addCourseET2;
    private EditText addCourseET3;
    private Button addCourseb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        databaseReference= FirebaseDatabase.getInstance().getReference("Course");
        addCourseET1=findViewById(R.id.addCourseET1);
        addCourseET2=findViewById(R.id.addCourseET2);
        addCourseET3=findViewById(R.id.addCourseET3);
        addCourseb2=findViewById(R.id.addCourseb2);
       addCourseb2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               saveData();
           }
       });
    }
public void saveData(){
        String CName=addCourseET1.getText().toString().trim();
        String CId=addCourseET2.getText().toString().trim();
        String CCredit=addCourseET3.getText().toString().trim();
        String key=databaseReference.push().getKey();
        AddCourseFirebase addCourseFirebase=new AddCourseFirebase(CName,CCredit);
        databaseReference.child(CId).setValue(addCourseFirebase);
    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
    addCourseET1.setText("");
    addCourseET2.setText("");
    addCourseET3.setText("");
}
}
