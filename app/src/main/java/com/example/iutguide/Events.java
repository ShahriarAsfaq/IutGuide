package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Events extends AppCompatActivity {
    Intent intent= getIntent();
    ListView eventlist;
    DatabaseReference event_List;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        eventlist=(ListView)findViewById(R.id.eventlist);
        //databaseReference= FirebaseDatabase.getInstance().getReference("Event1");
        event_List= FirebaseDatabase.getInstance().getReference("Event1");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Events.this,R.layout.sample_layout,R.id.listText, (List<String>) event_List);
        eventlist.setAdapter(adapter);
    }
}
