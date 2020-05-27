package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeacherPercentage extends AppCompatActivity {
Intent intent =getIntent();
String studentId;
Button teacherPercentageB1;
ListView teacherPercentageL1;
int cnt=0;
int cnt3=0;
int coursePosition;
double present[];
String courseName;
String studentlist[];
String dateList[];
DatabaseReference reference1;
DatabaseReference reference2;
DatabaseReference reference3;
DatabaseReference reference4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_percentage);
        teacherPercentageB1=(Button)findViewById(R.id.teacherPercentageB1);
        teacherPercentageL1=(ListView)findViewById(R.id.teacherPercentageL1);
        LogIn logIn=new LogIn();
        studentId=logIn.StudentId();
        final Course course =new Course();
        coursePosition=course.getposition();
        reference1= FirebaseDatabase.getInstance().getReference().child("Teacher_Course").child(studentId).child(String.valueOf(coursePosition));
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    courseName=dataSnapshot.child("courseId").getValue().toString();
                    Toast.makeText(getApplicationContext(),courseName, Toast.LENGTH_SHORT).show();
                    reference2=FirebaseDatabase.getInstance().getReference().child("Course_Student").child(courseName);
                    reference2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if(dataSnapshot.exists()){
                                cnt=(int)dataSnapshot.getChildrenCount();
                                studentlist=new String[cnt];
                                present=new double [cnt];
                                Toast.makeText(getApplicationContext(),String.valueOf(cnt), Toast.LENGTH_SHORT).show();
                                for(int i=1;i<=cnt;i++){
                                    studentlist[i-1]=dataSnapshot.child(String.valueOf(i)).getValue().toString();
                                    Toast.makeText(getApplicationContext(),studentlist[i-1], Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    reference3=FirebaseDatabase.getInstance().getReference().child("Course_Date").child(courseName);
                    reference3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                cnt3=(int)dataSnapshot.getChildrenCount();
                                dateList=new String[cnt3];
                                reference4=FirebaseDatabase.getInstance().getReference().child("Attendence").child(courseName);
                                for(int j=1;j<=cnt3;j++){
                                    dateList[j-1]=dataSnapshot.child(String.valueOf(j)).getValue().toString();
                                    Toast.makeText(getApplicationContext(),dateList[j-1], Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getApplicationContext(),String.valueOf(cnt), Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getApplicationContext(),courseName, Toast.LENGTH_SHORT).show();
                                    final int finalJ = j;
                                    reference4.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                            for(int k=1;k<=cnt;k++){
                                             String str=dataSnapshot.child(dateList[finalJ-1]).child(studentlist[k-1]).getValue().toString();
                                             if(str.compareTo("p")==0){
                                                 present[k-1]++;
                                             }
                                                Toast.makeText(getApplicationContext(),String.valueOf(present[k-1]), Toast.LENGTH_SHORT).show();
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

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        teacherPercentageB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),String.valueOf(cnt3), Toast.LENGTH_LONG).show();
                for(int i=1;i<=cnt;i++){
                    double round=((present[i-1]/cnt3)*100);
                    round=Math.round(round*100.0)/100.0;
                    present[i-1]=round;
                    studentlist[i-1]=studentlist[i-1]+"                         "+String.valueOf(present[i-1])+"%";
                    Toast.makeText(getApplicationContext(),studentlist[i-1], Toast.LENGTH_LONG).show();
                    if(i==cnt){
                      final ArrayAdapter adapter=new ArrayAdapter(TeacherPercentage.this,android.R.layout.simple_list_item_1,studentlist);
                        teacherPercentageL1.setAdapter(adapter);
                    }
                }

            }
        });
    }
}
