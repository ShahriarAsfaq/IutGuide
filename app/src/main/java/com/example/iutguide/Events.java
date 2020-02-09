package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Events extends AppCompatActivity {
    Intent intent= getIntent();
    ListView eventlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        eventlist=(ListView)findViewById(R.id.eventlist);
        String[] event_List= getResources().getStringArray(R.array.event_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Events.this,R.layout.sample_layout,R.id.listText,event_List);
        eventlist.setAdapter(adapter);
    }
}
