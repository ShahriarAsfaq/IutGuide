package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TasksTeacher extends AppCompatActivity {
    Intent intent=getIntent();
    Spinner spinner;
    EditText qname;
    EditText qtime;
    EditText qdate;
    EditText qdescribe;
    Button qAdd;
    DatabaseReference taskData;

    String[] task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_teacher);
        spinner=(Spinner)findViewById(R.id.spinner);
        qname=(EditText)findViewById(R.id.qname);
        qtime=(EditText)findViewById(R.id.qtime);
        qdate=(EditText)findViewById(R.id.qDate);
        qdescribe=(EditText)findViewById(R.id.qDescrip);
        qAdd=(Button)findViewById(R.id.qAdd);
        task=getResources().getStringArray(R.array.Task);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sample_tasks,R.id.sampletask,task);
        spinner.setAdapter(adapter);

        qAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qspinner=spinner.getSelectedItem().toString();
                String qname1=qname.getText().toString();
                String qtime1=qtime.getText().toString();
                String qdate1=qdate.getText().toString();
                String qdescribe1=qdescribe.getText().toString();

                taskData= FirebaseDatabase.getInstance().getReference(qspinner);
                taskData.child("Name").setValue(qname1);
                taskData.child("Time").setValue(qtime1);
                taskData.child("Date").setValue(qdate1);
                taskData.child("Description").setValue(qdescribe1);
            }
        });
    }
}
