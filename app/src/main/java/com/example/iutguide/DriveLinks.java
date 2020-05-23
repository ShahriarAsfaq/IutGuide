package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DriveLinks extends AppCompatActivity {
    Intent intent=getIntent();
    Button stdlink;
    Button techlink;
    Button addlinkbtn;
    EditText addlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_links);
        stdlink=(Button)findViewById(R.id.stdlink);
        techlink=(Button)findViewById(R.id.techlink);
        addlinkbtn=(Button)findViewById(R.id.addlinkbtn);
        addlink=(EditText) findViewById(R.id.addlink);

        stdlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DriveLinks.this,GoogleDrive.class);
                startActivity(intent);
            }
        });
    }
}
