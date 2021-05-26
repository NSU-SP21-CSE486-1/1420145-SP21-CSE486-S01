package com.example.nsu_cpcfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

public class CpcLoginActivity extends AppCompatActivity  {

    private EditText cpc_emailLog,cpc_passLog;
    private Button cpc_btnLog;
    private FirebaseAuth firebaseAuth;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpc_login);
        /*firebaseAuth=FirebaseAuth.getInstance();

        cpcLoginFunction();*/

        fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        LoginCpcFragment loginCpcFragment=new LoginCpcFragment();
        ft.add(R.id.fragmentContainer,loginCpcFragment);
        ft.commit();
    }

    /*private void cpcLoginFunction(){

        cpc_emailLog = findViewById(R.id.add_cpclogin_email_Input);
        cpc_passLog= findViewById(R.id.add_cpclogin_pass_Input);
        *//*deptLog =findViewById(R.id.add_dept_Input);*//*
        cpc_btnLog =findViewById(R.id.cpc_login);

        cpc_btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email =cpc_emailLog.getText().toString().trim();
                String pass =cpc_passLog.getText().toString().trim();
                *//*String dept = deptLog.getText().toString().trim();*//*


                if (TextUtils.isEmpty(email)){
                    cpc_emailLog.setError("Required field");

                }
                if (TextUtils.isEmpty(pass)){
                    cpc_passLog.setError("Required field");

                }
                *//*if (TextUtils.isEmpty(dept)){
                    deptLog.setError("Required field");

                }*//*

                firebaseAuth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                Toast.makeText(CpcLoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),CPCAdmin_Activity.class));

                            }


                        })

                        .addOnFailureListener(new OnFailureListener() {

                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(CpcLoginActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();

                            }
                        });




            }
        });


*/

    }
