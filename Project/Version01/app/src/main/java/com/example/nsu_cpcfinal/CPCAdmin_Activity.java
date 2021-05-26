package com.example.nsu_cpcfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CPCAdmin_Activity extends AppCompatActivity {
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpcadmin);

        btn1=findViewById(R.id.see_all_jobs);
        btn2=findViewById(R.id.post_job);

        getSupportActionBar().hide();
    }

    public void openJobsPortal(View view) {

        /*btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        new JobPortalFragment()).commit();
                btn1.setVisibility(view.GONE);
                btn2.setVisibility(view.GONE);
            }
        });
*/

    }

    public void postJob(View view) {
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        new AddJObFragment()).commit();
                btn1.setVisibility(view.GONE);
                btn2.setVisibility(view.GONE);
            }
        });

    }
}