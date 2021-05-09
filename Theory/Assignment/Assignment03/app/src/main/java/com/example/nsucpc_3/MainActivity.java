package com.example.nsucpc_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements LoginFragment.UserAuthListener, StudentListFragment
        .AddStudentListener {
    /*private EditText emailET,passwordET,birthdayET,phoneET,nidET,presentAddET,permanentAddET,
            nameET,idET,deptET;*/

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*nameET=findViewById(R.id.nameinput);
        emailET=findViewById(R.id.emailinputET);
        idET=findViewById(R.id.idinputET);
        passwordET=findViewById(R.id.passwoedinput);
        *//*btn=findViewById(R.id.login_Button);*//*
        deptET=findViewById(R.id.dept_name_imput);
        birthdayET=findViewById(R.id.birthday_input);
        phoneET=findViewById(R.id.phone_input);
        nidET=findViewById(R.id.nid_input);
        presentAddET=findViewById(R.id.present_address_input);
        permanentAddET=findViewById(R.id.permanent_address_input);*/

        fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        LoginFragment loginFragment=new LoginFragment();
        ft.add(R.id.fragmentContainer,loginFragment);
        ft.commit();
    }

    @Override
    public void onLoginSuccessful() {
        FragmentTransaction ft=fragmentManager.beginTransaction();
        StudentListFragment studentListFragment=new StudentListFragment();
        ft.replace(R.id.fragmentContainer,studentListFragment);
        ft.commit();

    }

    @Override
    public void onAddBtnClicked() {

        FragmentTransaction ft=fragmentManager.beginTransaction();
        AddStudentFragment addStudentFragment= new AddStudentFragment();
        ft.replace(R.id.fragmentContainer,addStudentFragment);
        ft.addToBackStack(null);
        ft.commit();

    }
}