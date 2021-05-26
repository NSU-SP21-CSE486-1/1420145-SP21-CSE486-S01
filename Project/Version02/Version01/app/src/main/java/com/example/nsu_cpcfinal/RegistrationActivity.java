package com.example.nsu_cpcfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private EditText  emailReg,passReg/*, deptReg,birthdayReg,
            nidReg,phnReg, presentReg,permanentReg*/;
    private Button reg_btnReg;

    FirebaseAuth mAuth;


    /*private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private DatabaseReference userIdRef;
    private DatabaseReference studentRef;
    private FirebaseUser currentUser;*/
    /*private OnAddStudentSuccessListener listener;*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regFunction();
        mAuth=FirebaseAuth.getInstance();

        /*private EditText nameReg, emailReg, deptReg,birthdayReg,
                nidReg,phnReg, presentReg,permanentReg;*/




        /*rootRef = FirebaseDatabase.getInstance().getReference();
        userRef = rootRef.child("Users");
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        userIdRef = userRef.child(currentUser.getUid());
        studentRef = userIdRef.child("Students");*/
    }

    private void regFunction(){


        emailReg=findViewById(R.id.add_reg_email_Input);
        passReg=findViewById(R.id.add_reg_passInput);
        reg_btnReg=findViewById(R.id.add_reg_registration_Input);
        /*deptReg= findViewById(R.id.add_reg_dept_Input);
        birthdayReg=findViewById(R.id.add_reg_birthday_Input);
        nidReg=findViewById(R.id.add_reg_nid_Input);
        phnReg=findViewById(R.id.add_reg_phone_Input);
        presentReg=findViewById(R.id.add_reg_present_Input);
        permanentReg=findViewById(R.id.add_reg_permanent_Input);
        reg_btnReg=findViewById(R.id.add_reg_registration_Input);*/

        reg_btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailR=emailReg.getText().toString().trim();
                String passR=passReg.getText().toString().trim();
                /*String deptR=deptReg.getText().toString().trim();
                String birthdayR=birthdayReg.getText().toString().trim();
                String nidR=nidReg.getText().toString().trim();
                String phoneR=phnReg.getText().toString().trim();
                String presentR=presentReg.getText().toString().trim();
                String permanentR=permanentReg.getText().toString().trim();*/


                if (TextUtils.isEmpty(emailR)){
                    emailReg.setError("Required field");

                }
                if (TextUtils.isEmpty(passR)){
                    passReg.setError("Required field");

                }
                /*if (TextUtils.isEmpty(deptR)){
                    deptReg.setError("Required field");

                }
                if (TextUtils.isEmpty(birthdayR)){
                    birthdayReg.setError("Required field");

                }
                if (TextUtils.isEmpty(nidR)){
                    nidReg.setError("Required field");

                }
                if (TextUtils.isEmpty(phoneR)){
                    phnReg.setError("Required field");

                }
                if (TextUtils.isEmpty(presentR)){
                    presentReg.setError("Required field");

                }
                if (TextUtils.isEmpty(permanentR)){
                    permanentReg.setError("Required field");

                }

*/
                mAuth.createUserWithEmailAndPassword(emailR,passR)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                Toast.makeText(RegistrationActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),JobActivity.class));

                            }


                        })

                        .addOnFailureListener(new OnFailureListener() {

                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(RegistrationActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();

                            }
                        });




            }
        });


    }
}