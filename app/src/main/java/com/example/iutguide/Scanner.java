package com.example.iutguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    String qrCode;
    ZXingScannerView ScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScannerView=new ZXingScannerView(Scanner.this);
        setContentView(ScannerView);

    }

    @Override
    public void handleResult(Result result) {
        qrCode=result.getText();
        StudentAttendence.studentAttendenceT1.setText(result.getText());
         onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        ScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ScannerView.setResultHandler(Scanner.this);
        ScannerView.startCamera();
    }
    String getQrCode(){
        return qrCode;
    }
}
