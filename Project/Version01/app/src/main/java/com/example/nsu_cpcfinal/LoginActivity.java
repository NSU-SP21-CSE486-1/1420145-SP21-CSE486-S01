package com.example.nsu_cpcfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText  emailLog,passLog ;
    private Button login_btn_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginFunction();
    }

    private void loginFunction(){


        emailLog = findViewById(R.id.add_email_Input);
        passLog = findViewById(R.id.add_pass_Input);
        /*deptLog =findViewById(R.id.add_dept_Input);*/
        login_btn_log =findViewById(R.id.login);

        login_btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email =emailLog.getText().toString().trim();
                String pass =passLog.getText().toString().trim();
                /*String dept = deptLog.getText().toString().trim();*/


                if (TextUtils.isEmpty(pass)){
                    passLog.setError("Required field");

                }
                if (TextUtils.isEmpty(email)){
                    emailLog.setError("Required field");

                }
                /*if (TextUtils.isEmpty(dept)){
                    deptLog.setError("Required field");

                }*/

            }
        });

    }
}