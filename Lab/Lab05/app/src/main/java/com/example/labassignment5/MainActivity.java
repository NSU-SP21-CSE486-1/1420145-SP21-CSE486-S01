package com.example.labassignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailET,passwordET;
    private Button btn;
    public static final String EMAIL="jubair.ovi@northsouth.edu";
    public static final String PAAS="1234";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET=findViewById(R.id.emailinputET);
        passwordET=findViewById(R.id.passwoedinput);
        btn=findViewById(R.id.login_Button);
    }

    public void Login(View view) {
        String email = emailET.getText().toString();
        String pass = passwordET.getText().toString();
        if (email.equals(EMAIL) && pass.equals(PAAS)){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }
        if (email.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "Provide email and pass ", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "wrong email or password ", Toast.LENGTH_SHORT).show();
        }
    }
}