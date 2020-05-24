package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.DefaultTaskExecutor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Student_Course extends AppCompatActivity {
    Intent intent=getIntent();
  private ListView listView;
static int position1;
int cnt=0;
private static  int verify;
   ArrayList<String> myArrayList= new ArrayList<>();

   DatabaseReference myref;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__course);

      Student_Batch student_batch=new Student_Batch();
        final ArrayAdapter<String> myArrayAdepter=new ArrayAdapter<String>(Student_Course.this,android.R.layout.simple_list_item_1,myArrayList);
     listView=(ListView) findViewById(R.id.StudentCourseL1);

     listView.setAdapter(myArrayAdepter);
      String str=student_batch.getBatchName();
     myref=FirebaseDatabase.getInstance().getReference().child("Batch_Course").child(str);
myref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
   if(dataSnapshot.exists()){
       cnt=(int)dataSnapshot.getChildrenCount();
   }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
     myref.addChildEventListener(new ChildEventListener() {
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                for(int i=0;i<cnt;i++) {
                    if (position == i) {
                        position1 = (i+1);
                        verify=1;
                        Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(getApplicationContext(), CourseDetails.class);
                        startActivity(intent3);


                    }
                }
            }
        });

    }

int position(){
        return position1;
}
int verify(){
        return verify;
}

}
