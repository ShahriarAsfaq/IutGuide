package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentResource extends AppCompatActivity {
    Intent intent = getIntent();
    ListView resourceList;
    Button reload;
    private DatabaseReference studentBatch;
    private DatabaseReference courses;
    private DatabaseReference resourcesList;
    String batchName;
    String courseList[];
    String[] resourceTitles = new String[100];
    String[] resourceLinks = new String[100];
    int cnt=0, lintCount=0, temp1=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_resource);

        LogIn logIn=new LogIn();
        String SID= logIn.StudentId();

        studentBatch= FirebaseDatabase.getInstance().getReference().child("Batch_Selected").child(SID);
        studentBatch.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                batchName = dataSnapshot.getValue().toString();

                courses = FirebaseDatabase.getInstance().getReference().child("Batch_Course").child(batchName);
                courses.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            cnt = (int) dataSnapshot.getChildrenCount();
                            courseList = new String[cnt];
                            for(int i=1;i<=cnt;i++){
                                courseList[i-1] = dataSnapshot.child(String.valueOf(i)).getValue().toString();
                                Toast.makeText(getApplicationContext(),courseList[i-1],Toast.LENGTH_SHORT).show();

                                resourcesList = FirebaseDatabase.getInstance().getReference().child("Resource").child(courseList[i-1]);
                                resourcesList.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if(dataSnapshot.exists()){
                                            lintCount = (int) dataSnapshot.getChildrenCount();
                                            for (int j = 1;j<=lintCount;j++){

                                                resourceTitles[temp1] = dataSnapshot.child(String.valueOf(j)).child("resourceTitle").getValue().toString();
                                                resourceLinks[temp1] = dataSnapshot.child(String.valueOf(j)).child("resourceLink").getValue().toString();

                                                temp1++;
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });


                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        resourceList = findViewById(R.id.resourceListview);
        reload = findViewById(R.id.reloadResourceButton);

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int k =0;k<temp1;k++){

                    Toast.makeText(getApplicationContext(),resourceTitles[k], Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),resourceLinks[k], Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}