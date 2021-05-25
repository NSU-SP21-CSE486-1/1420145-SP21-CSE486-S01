package com.example.nsu_cpcfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    private Context context;
    private EditText nameET, emailET,idlET, deptET,birthdayET,
            nidET,phnET, presentET,permanentT;
    private Button addBtn;

    private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private DatabaseReference userIdRef;
    private DatabaseReference studentRef;
    private FirebaseUser currentUser;
    /*private OnAddStudentSuccessListener listener;*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameET = findViewById(R.id.add_empNameInput);
        emailET = findViewById(R.id.add_email_Input);
        /*idlET = view.findViewById(R.id.add_id_Input);*/
        deptET = findViewById(R.id.add_dept_Input);
        birthdayET = findViewById(R.id.add_birthday_Input);
        nidET = findViewById(R.id.add_nid_Input);
        phnET = findViewById(R.id.add_phone_Input);
        presentET = findViewById(R.id.add_present_Input);
        permanentT = findViewById(R.id.add_permanent_Input);
        addBtn = findViewById(R.id.addNewEmployee);

        rootRef = FirebaseDatabase.getInstance().getReference();
        userRef = rootRef.child("Users");
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        userIdRef = userRef.child(currentUser.getUid());
        studentRef = userIdRef.child("Students");







    }
}