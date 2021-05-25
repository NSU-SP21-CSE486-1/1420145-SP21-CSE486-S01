package com.example.nsucpc_3;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class StudentListFragment extends Fragment {
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private Context context;
    private AddStudentListener listener;
    private StudentAdapter adapter;
    private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private DatabaseReference userIdRef;
    private DatabaseReference studentRef;
    private FirebaseUser currentUser;


    public StudentListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        listener= (AddStudentListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootRef = FirebaseDatabase.getInstance().getReference();
        userRef = rootRef.child("Users");
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        userIdRef = userRef.child(currentUser.getUid());
        studentRef = userIdRef.child("Students");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAddBtnClicked();

            }
        });
        studentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                List<Student> studentList = new ArrayList<>();
                for (DataSnapshot d : snapshot.getChildren()){
                    Student s = d.getValue(Student.class);
                    studentList.add(s);
                }

                adapter = new StudentAdapter(context, studentList);
                LinearLayoutManager llm = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public interface AddStudentListener{
        void onAddBtnClicked();
    }
}