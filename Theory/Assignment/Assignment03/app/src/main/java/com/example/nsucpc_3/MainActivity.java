package com.example.nsucpc_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText emailET,passwordET,birthdayET,phoneET,nidET,presentAddET,permanentAddET,
            nameET,idET,deptET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameET=findViewById(R.id.nameinput);
        emailET=findViewById(R.id.emailinputET);
        idET=findViewById(R.id.idinputET);
        passwordET=findViewById(R.id.passwoedinput);
        /*btn=findViewById(R.id.login_Button);*/
        deptET=findViewById(R.id.dept_name_imput);
        birthdayET=findViewById(R.id.birthday_input);
        phoneET=findViewById(R.id.phone_input);
        nidET=findViewById(R.id.nid_input);
        presentAddET=findViewById(R.id.present_address_input);
        permanentAddET=findViewById(R.id.permanent_address_input);
    }
}