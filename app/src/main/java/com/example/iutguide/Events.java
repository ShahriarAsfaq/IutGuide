package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Events extends AppCompatActivity {
    Intent intent= getIntent();
    TextView event1;
    TextView event2;
    DatabaseReference eventData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
       event1=(TextView)findViewById(R.id.event1);
       event2=(TextView)findViewById(R.id.event2);
       eventData = FirebaseDatabase.getInstance().getReference("event");
       //eventData.setValue("hello world");
       eventData.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               //for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                  // EventDatabase eventDatabase = dataSnapshot.getValue(EventDatabase.class);
              // }
               String value = dataSnapshot.getValue(String.class);

               event1.setText(value);
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

    }
}
