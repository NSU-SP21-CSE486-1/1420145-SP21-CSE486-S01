package com.example.nsu_cpcfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AllJobsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    private FirebaseAuth mAuth;
    private DatabaseReference mJobpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_jobs);

        recyclerView=findViewById(R.id.recy);
        fab=findViewById(R.id.fab);

        mAuth=FirebaseAuth.getInstance();
        FirebaseUser muser=mAuth.getCurrentUser();
        String uid=muser.getUid();
        mJobpost=FirebaseDatabase.getInstance().getReference().child("Job Post").child("uid");

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager();
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),JobActivity.class);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public static class MyViewHolder extends RecyclerView.ViewCacheExtension{


        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}