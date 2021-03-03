package com.example.cselab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count=0;
    private Button btn1,btn3;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.button1);
        btn3=findViewById(R.id.button2);
        textView =findViewById(R.id.showCount);
    }

    public void showToast(View view) {
        Toast toast=new Toast(this);
        Toast.makeText(this, "Hellow Developer", Toast.LENGTH_SHORT).show();
    }

    public void countup(View view) {
        count++;
        if(textView!=null){
            textView.setText(Integer.toString(count));

        }
    }
}