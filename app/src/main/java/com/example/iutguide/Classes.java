package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Classes extends AppCompatActivity {
    Intent intent= getIntent();
    private TextView Date;
    private TextView extraclass;
    private ListView classList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
    Date=(TextView)findViewById(R.id.date);
    classList=(ListView) findViewById(R.id.classlist);
    extraclass=(TextView)findViewById(R.id.extraclass);
    String[] class_List= getResources().getStringArray(R.array.class_List);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Classes.this,R.layout.sample_layout,R.id.listText,class_List);
    classList.setAdapter(adapter);
    }
}
