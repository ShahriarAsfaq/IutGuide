package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class activity_push extends AppCompatActivity {
    private ListView listView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);
        String [] countryName=getResources().getStringArray(R.array.country_Name);
        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(activity_push.this,R.layout.sample_layout,R.id.listText,countryName);
        listView.setAdapter(adapter);
    }
}
