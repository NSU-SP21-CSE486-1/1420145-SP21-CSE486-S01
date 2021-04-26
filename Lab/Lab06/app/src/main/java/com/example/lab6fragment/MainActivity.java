package com.example.lab6fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft= fragmentManager.beginTransaction();
        LoginFragment loginFragment=new LoginFragment();
        ft.add(R.id.fragmentContainer,loginFragment);
        ft.commit();
    }
}