package com.example.nsu_cpcfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CPCAdmin_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpcadmin);

        getSupportActionBar().hide();
    }

    public void openAllJobs(View view) {
        Intent intent =new Intent(CPCAdmin_Activity.this,AllJobsActivity.class);
        startActivity(intent);
    }

    public void openPostJob(View view) {
        Intent intent =new Intent(CPCAdmin_Activity.this,JobActivity.class);
        startActivity(intent);
    }
}