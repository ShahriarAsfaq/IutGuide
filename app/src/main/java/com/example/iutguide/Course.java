package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class  Course extends AppCompatActivity {
    Intent intent= getIntent();
   private ListView listView;
   Button CourseB1;
   private List<AddCourseFirebase> addCourseFirebaseList;
   private CourseAdapter courseAdapter;
   DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        mDatabase=FirebaseDatabase.getInstance().getReference("Course");

        addCourseFirebaseList=new ArrayList<>();

        courseAdapter=new CourseAdapter(Course.this,addCourseFirebaseList);
        listView=findViewById(R.id.courseL1);
        CourseB1=findViewById(R.id.CourseB);
        CourseB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Course.this,addCourse.class);
                startActivity(intent);
            }
        });
       
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0) {
                    Intent intent3 = new Intent(getApplicationContext(),CourseDetails.class);
                    startActivity(intent3);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                addCourseFirebaseList.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    AddCourseFirebase addCourseFirebase=dataSnapshot1.getValue(AddCourseFirebase.class);
                    addCourseFirebaseList.add(addCourseFirebase);
                }

                listView.setAdapter(courseAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
