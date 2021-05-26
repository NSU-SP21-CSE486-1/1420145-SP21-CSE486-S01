package com.example.nsu_cpcfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nsu_cpcfinal.Model.Job;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class JobActivity extends AppCompatActivity {

    private EditText jobname,jobdes,jobsalary,jobstatus;
    private Button jobPostBtn;
    private FirebaseAuth mAuth;
    private DatabaseReference mJobpost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        mAuth=FirebaseAuth.getInstance();
        FirebaseUser muser=mAuth.getCurrentUser();
        String uid=muser.getUid();

        mJobpost=FirebaseDatabase.getInstance().getReference().child("Job Post").child("uid");
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
                if (TextUtils.isEmpty(salary)){
                    jobsalary.setError("Required field");

                }
                if (TextUtils.isEmpty(status)){
                   jobstatus.setError("Required field");

                }
                String id=mJobpost.push().getKey();
                String date= DateFormat.getDateInstance().format(new Date());
                Job job= new Job(name,description,salary,status);
                mJobpost.child(id).setValue(job);
                Toast.makeText(JobActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),AllJobsActivity.class));

            }
        });

    }
}