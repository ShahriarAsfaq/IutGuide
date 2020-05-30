package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeacherProject extends AppCompatActivity {
    Intent intent=getIntent();
    private Button addProject;
    DatabaseReference reference1;
    private ListView listviewProject;
    ArrayList<String> myArrayList= new ArrayList<>();
String teacherId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_project);
        LogIn login=new LogIn();
        teacherId=login.StudentId();


        addProject = findViewById(R.id.projectaddbutton);
        addProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(TeacherProject.this,Project.class);
                startActivity(intent);

            }

        });

        listviewProject = findViewById(R.id.projectlistview);
        reference1= FirebaseDatabase.getInstance().getReference().child("Teacher_Project").child(teacherId);
        final ArrayAdapter<String> myArrayAdepter=new ArrayAdapter<String>(TeacherProject.this,android.R.layout.simple_list_item_1,myArrayList);


        listviewProject.setAdapter(myArrayAdepter);



                reference1.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        String value=dataSnapshot.getValue(String.class);
                        myArrayList.add(value);
                        myArrayAdepter.notifyDataSetChanged();

                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        myArrayAdepter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }


    }

