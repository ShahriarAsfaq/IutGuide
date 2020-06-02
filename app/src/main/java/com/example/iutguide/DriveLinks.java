package com.example.iutguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DriveLinks extends AppCompatActivity {
    Intent intent=getIntent();
    Button stdlink;
    Button techlink;
    Button addlinkbtn;
    EditText addlink;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_links);
        stdlink=(Button)findViewById(R.id.stdlink);
        techlink=(Button)findViewById(R.id.techlink);
        addlinkbtn=(Button)findViewById(R.id.addlinkbtn);
        addlink=(EditText) findViewById(R.id.addlink);
        //linkbox=(ListView) findViewById(R.id.linkbox);

        tv=(TextView)findViewById(R.id.textView2);






    }
}
