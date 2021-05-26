package com.example.nsu_cpcfinal;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;


public class AddJObFragment extends Fragment {


    private Context context;

    private EditText nameJob,deptJob,descriptionJOb,salaryJob,statusJOb;
    private Button addJobBtn;
    private Addjoblistner addjoblistner;

    public AddJObFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull @org.jetbrains.annotations.NotNull Context context) {
        super.onAttach(context);
        this.context=context;
        //jobListListner= (JobPortalFragment.jobListListner) context;
        addjoblistner= (Addjoblistner) context;
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_j_ob, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameJob=view.findViewById(R.id.add_Job_NameInput);
        deptJob=view.findViewById(R.id.add_job_dept_Input);
        descriptionJOb=view.findViewById(R.id.add_job_description_Input);
        salaryJob=view.findViewById(R.id.add_job_salary_Input);
        statusJOb=view.findViewById(R.id.add_job_status_Input);
        addJobBtn=view.findViewById(R.id.job_addButton);
        addJobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addjoblistner.onAddJobButtonClicl();

            }
        });
    }
    public interface Addjoblistner{
        void onAddJobButtonClicl();
    }



}