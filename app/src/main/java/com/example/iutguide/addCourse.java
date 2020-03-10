package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addCourse extends AppCompatActivity {
    Intent intent= getIntent();
    DatabaseReference databaseReference;
    private TextView addCoursetext;
    private EditText addCourseEText;
    private Button addCourseb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        addCoursetext=findViewById(R.id.addCoursetext);
        addCourseEText=findViewById(R.id.addCourseEText);
        addCourseb2=findViewById(R.id.addCourseb2);
       addCourseb2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               saveData();
           }
       });
    }
public void saveData(){
        String Name=addCourseEText.getText().toString().trim();
        String Key=databaseReference.push().getKey();
        AddCourseFirebase addCourseFirebase=new AddCourseFirebase(Name);
        databaseReference.child(Key).setValue(addCourseFirebase);
}
}
