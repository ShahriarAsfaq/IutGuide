package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GoogleDrive extends AppCompatActivity {
    Intent intent= getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_drive);
        WebView drive_link;
        drive_link=(WebView)findViewById(R.id.Gdrive);
        drive_link.loadUrl("https://drive.google.com/drive/folders/17zsgyKFr54LLozsPjtbWXg8p0zCNC0uS?fbclid=IwAR2lKJN4OT5MDefBXSAaxpOeVmijI_rRHQ0ozvho01j093NMYk4ID5nUx6w");
        WebSettings webSettings= drive_link.getSettings();
        webSettings.setJavaScriptEnabled(true);
        drive_link.setWebViewClient(new WebViewClient());
    }
}
