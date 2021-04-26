package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nsucpc.adapters.StudentAdapter;
import com.example.nsucpc.db.StudentDatabase;
import com.example.nsucpc.models.Student;

import java.util.List;

public class StudentListActivity extends AppCompatActivity {
    private RecyclerView recyclerView_st;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        recyclerView_st=findViewById(R.id.studentRv);
        List<Student> students =
                StudentDatabase.getInstance(this)
                        .getStudentDao()
                        .getAllStudents();
        adapter=new StudentAdapter(this,students);
        recyclerView_st.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_st.setAdapter(adapter);





    }



    public void addNewStudent(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}