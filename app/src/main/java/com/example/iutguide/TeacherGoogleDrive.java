package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TeacherGoogleDrive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_google_drive);
        WebView driveLink;
        driveLink=(WebView)findViewById(R.id.teacherGoogleDrive);
        driveLink.loadUrl("https://drive.google.com/drive/folders/17zsgyKFr54LLozsPjtbWXg8p0zCNC0uS?fbclid=IwAR2lKJN4OT5MDefBXSAaxpOeVmijI_rRHQ0ozvho01j093NMYk4ID5nUx6w");
        WebSettings webSettings= driveLink.getSettings();
        webSettings.setJavaScriptEnabled(true);
        driveLink.setWebViewClient(new WebViewClient());
    }
}
