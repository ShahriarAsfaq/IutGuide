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
    ListView linkbox;

    int count=0;
    String link_value[];

    DatabaseReference link_box;
    DatabaseReference link_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_links);
        stdlink=(Button)findViewById(R.id.stdlink);
        techlink=(Button)findViewById(R.id.techlink);
        addlinkbtn=(Button)findViewById(R.id.addlinkbtn);
        addlink=(EditText) findViewById(R.id.addlink);
        linkbox=(ListView) findViewById(R.id.linkbox);




        stdlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DriveLinks.this,GoogleDrive.class);
                startActivity(intent);
            }
        });

        addlinkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link= addlink.getText().toString();
                String Count= String.valueOf(count);
                link_box.child(Count).setValue(link);

                link_data = FirebaseDatabase.getInstance().getReference("link_box/count");

                count++;
            }

        });



        link_data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                for(int i=0;i<count;i++){
                    link_value[i]= value;
                }
                ArrayAdapter<String> adapter=new  ArrayAdapter<String>(DriveLinks.this,R.layout.drivelink_sample,R.id.sampleLink,link_value);
                linkbox.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
