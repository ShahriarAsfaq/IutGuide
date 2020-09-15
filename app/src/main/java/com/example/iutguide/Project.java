package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
   int cnt3=0;
   int cnt4=0,stdcnt1=0,stdcnt2=0,stdcnt3=0;
   int cnt5=0;
    DatabaseReference reference1;
    DatabaseReference reference2;
    DatabaseReference reference3;
    DatabaseReference reference4;
    DatabaseReference reference5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        projectName = findViewById(R.id.projectname);
        student1 = findViewById(R.id.student1);
        student2 = findViewById(R.id.student2);
        student3 = findViewById(R.id.student3);
        reference2=FirebaseDatabase.getInstance().getReference().child("Project_Teacher");
        reference4=FirebaseDatabase.getInstance().getReference().child("Student_Project");
        //reference5=FirebaseDatabase.getInstance().getReference().child("Project_Student");

        reference3=FirebaseDatabase.getInstance().getReference().child("Project");
        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    cnt3= (int) dataSnapshot.getChildrenCount();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    cnt4 = (int) dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        student1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
          String str=student1.getText().toString();
              if(str.length()==9){
                  std1=str;
                  reference4.addValueEventListener(new ValueEventListener() {
                      @Override
                      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                     if(dataSnapshot.child(std1).exists()){
                         stdcnt1= (int) dataSnapshot.child(std1).getChildrenCount();
                         Toast.makeText(getApplicationContext(), String.valueOf(stdcnt1), Toast.LENGTH_SHORT).show();
                     }
                      }

                      @Override
                      public void onCancelled(@NonNull DatabaseError databaseError) {

                      }
                  });
              }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        student2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String str=student2.getText().toString();
                if(str.length()==9){
                    std2=str;
                    reference4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.child(std2).exists()){
                                stdcnt2= (int) dataSnapshot.child(std2).getChildrenCount();
                                Toast.makeText(getApplicationContext(), String.valueOf(stdcnt2), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        student3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String str=student3.getText().toString();
                if(str.length()==9){
                    std3=str;
                    reference4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.child(std3).exists()){
                                stdcnt3= (int) dataSnapshot.child(std3).getChildrenCount();
                                Toast.makeText(getApplicationContext(), String.valueOf(stdcnt3), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        addProject = findViewById(R.id.addprojectbutton);
        LogIn logIn=new LogIn();
        teacherId=logIn.StudentId();
        reference1=FirebaseDatabase.getInstance().getReference().child("Teacher_Project").child(teacherId);



        addProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proName = projectName.getText().toString();
                reference3.child(String.valueOf((cnt3+1))).setValue(proName);
                reference1.child(proName).child(String.valueOf(1)).setValue(std1);
                reference1.child(proName).child(String.valueOf(2)).setValue(std2);
                reference1.child(proName).child(String.valueOf(3)).setValue(std3);
               reference2.child(proName).setValue(teacherId);
                reference4.child(std1).child(String.valueOf((stdcnt1+1))).setValue(proName);
                reference4.child(std2).child(String.valueOf((stdcnt2+1))).setValue(proName);
                reference4.child(std3).child(String.valueOf((stdcnt3+1))).setValue(proName);
                Toast.makeText(getApplicationContext(), String.valueOf(cnt), Toast.LENGTH_SHORT).show();




            }
        });
    }
}
