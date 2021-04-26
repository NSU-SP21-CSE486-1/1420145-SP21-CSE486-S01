package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int count =0;
    Button btn1,btn2;
    ImageView imageIv;

    private int[] images = {R.drawable.app, R.drawable.develop, R.drawable.newyear};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        imageIv=findViewById(R.id.imageView);
        imageIv.setImageResource(images[count]);

    }


    public void changeImage(View view) {

        count++;
        if (count ==2){
            btn1.setEnabled(false);


        }
        imageIv.setImageResource(images[count]);
    }

    public void previousImage(View view) {

        imageIv.setImageResource(images[count--]);


        if (count==0){
            btn2.setEnabled(false);
            btn1.setEnabled(true);

        }
    }
}