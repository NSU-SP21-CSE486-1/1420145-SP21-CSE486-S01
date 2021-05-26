package com.example.nsu_cpcfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText  emailLog,passLog ;
    private Button login_btn_log;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();
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

                firebaseAuth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                Toast.makeText(LoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),JobActivity.class));

                            }


                        })

                        .addOnFailureListener(new OnFailureListener() {

                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();

                            }
                        });




            }
        });

            

    }
}