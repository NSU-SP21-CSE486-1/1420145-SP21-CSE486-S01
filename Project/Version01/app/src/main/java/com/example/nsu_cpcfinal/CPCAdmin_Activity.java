package com.example.nsu_cpcfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CPCAdmin_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpcadmin);

        getSupportActionBar().hide();
    }
}