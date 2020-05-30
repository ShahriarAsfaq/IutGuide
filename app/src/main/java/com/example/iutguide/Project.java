package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Project extends AppCompatActivity {
    Intent intent=getIntent();
    private EditText projectName;
    private EditText student1;
    private EditText student2;
    private EditText student3;
    private Button addProject;

    String teacherId,std1, std2, std3, proName;
   int cnt=1;
   int cnt2=0;
    DatabaseReference reference1;
    DatabaseReference reference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        projectName = findViewById(R.id.projectname);
        student1 = findViewById(R.id.student1);
        student2 = findViewById(R.id.student2);
        student3 = findViewById(R.id.student3);
        addProject = findViewById(R.id.addprojectbutton);
        LogIn logIn=new LogIn();
        teacherId=logIn.StudentId();
        reference1=FirebaseDatabase.getInstance().getReference().child("Teacher_Project").child(teacherId);
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    cnt= (int) dataSnapshot.getChildrenCount();
                    cnt++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        addProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proName = projectName.getText().toString();
                std1 = student1.getText().toString();
                std2 = student2.getText().toString();
                std3 = student3.getText().toString();

                reference2=FirebaseDatabase.getInstance().getReference().child("Project").child(teacherId).child(proName);

                Toast.makeText(getApplicationContext(), String.valueOf(cnt), Toast.LENGTH_SHORT).show();
                reference1.child(String.valueOf(cnt)).setValue(proName);

                reference2.child("1").setValue(std1);
                reference2.child("3").setValue(std2);
                reference2.child("2").setValue(std3);



            }
        });
    }
}
