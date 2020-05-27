package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
   int cnt=0;
   int cnt2=0;
    DatabaseReference reference1;

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


        addProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proName = projectName.getText().toString();
                std1 = student1.getText().toString();
                std2 = student2.getText().toString();
                std3 = student3.getText().toString();

                reference1= FirebaseDatabase.getInstance().getReference().child("Project").child(teacherId);
                reference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            cnt= (int) dataSnapshot.getChildrenCount();
                            cnt++;
                            reference1.child(String.valueOf(cnt)).child("ProjectName").setValue(proName);
                            reference1.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        cnt2= (int) dataSnapshot.getChildrenCount();
                                        cnt2++;
                                      if(!std1.isEmpty()){
                                          reference1.child(String.valueOf(cnt2)).setValue(std1);
                                          cnt2++;
                                      }

                                      if(!std2.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std2);
                                            cnt2++;
                                        }
                                      if(!std3.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std3);
                                        }
                                    }
                                    else{
                                        cnt2=1;
                                        if(!std1.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std1);
                                            cnt2++;
                                        }

                                        if(!std2.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std2);
                                            cnt2++;
                                        }
                                        if(!std3.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std3);
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }
                        else{
                                cnt=1;
                            reference1.child(String.valueOf(cnt)).child("ProjectName").setValue(proName);
                            reference1.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        cnt2= (int) dataSnapshot.getChildrenCount();
                                        cnt2++;
                                        if(!std1.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std1);
                                            cnt2++;
                                        }

                                        if(!std2.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std2);
                                            cnt2++;
                                        }
                                        if(!std3.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std3);
                                        }
                                    }
                                    else{
                                        cnt2=1;
                                        if(!std1.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std1);
                                            cnt2++;
                                        }

                                        if(!std2.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std2);
                                            cnt2++;
                                        }
                                        if(!std3.isEmpty()){
                                            reference1.child(String.valueOf(cnt2)).setValue(std3);
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }
                        }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
