package com.example.nsu_cpcfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JobActivity extends AppCompatActivity {

    private EditText jobname,jobdes,jobsalary,jobstatus;
    private Button jobPostBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        postJob();
    }


    private void postJob(){
        jobname=findViewById(R.id.add_jobName_Input);
        jobdes=findViewById(R.id.job_des_Input);
        jobsalary=findViewById(R.id.job_salary_Input);
        jobstatus=findViewById(R.id.job_Status_Input);
        jobPostBtn=findViewById(R.id.job_Post_btn);

        jobPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=jobname.getText().toString().trim();
                String description =jobdes.getText().toString().trim();
                String salary =jobsalary.getText().toString().trim();
                String status =jobstatus.getText().toString().trim();



                if (TextUtils.isEmpty(name)){
                    jobname.setError("Required field");

                }
                if (TextUtils.isEmpty(description)){
                   jobdes.setError("Required field");

                }
                if (TextUtils.isEmpty(salary){
                    jobsalary.setError("Required field");

                }
                if (TextUtils.isEmpty(status)){
                   jobstatus.setError("Required field");

                }

            }
        });

    }
}