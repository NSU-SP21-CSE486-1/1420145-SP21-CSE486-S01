package com.example.nsu_cpcfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        signup_btn=findViewById(R.id.sign_up);
    }

    public void openRegActivity(View view) {

        Intent intent =new Intent(HomeActivity.this,RegistrationActivity.class);
        startActivity(intent);
    }

    public void openSigninActivity(View view) {
        Intent intent =new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    public void openCpcAdmin(View view) {

        Intent intent =new Intent(HomeActivity.this,CpcLoginActivity.class);
        startActivity(intent);


    }

    public void openCpcSignup(View view) {
        Intent intent =new Intent(HomeActivity.this,CpcSignupActivity.class);
        startActivity(intent);
    }
}