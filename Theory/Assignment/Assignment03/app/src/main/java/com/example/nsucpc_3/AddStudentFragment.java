package com.example.nsucpc_3;

import android.app.Fragment;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddStudentFragment extends Fragment {

    private Context context;
    private EditText nameET, emailET,idlET, deptET,birthdayET,
            nidET,phnET, presentET,permanentT;
    private Button addBtn;

    private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private DatabaseReference userIdRef;
    private DatabaseReference studentRef;
    private FirebaseUser currentUser;
    private OnAddStudentSuccessListener listener;

    public AddStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        listener= (OnAddStudentSuccessListener) context;

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
        return inflater.inflate(R.layout.fragment_add_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameET = view.findViewById(R.id.add_empNameInput);
        emailET = view.findViewById(R.id.add_email_Input);
        /*idlET = view.findViewById(R.id.add_id_Input);*/
        deptET = view.findViewById(R.id.add_dept_Input);
       birthdayET = view.findViewById(R.id.add_birthday_Input);
        nidET = view.findViewById(R.id.add_nid_Input);
        phnET = view.findViewById(R.id.add_phone_Input);
        presentET = view.findViewById(R.id.add_present_Input);
       permanentT = view.findViewById(R.id.add_permanent_Input);
        addBtn = view.findViewById(R.id.addNewEmployee);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameET.getText().toString();
                String email = emailET.getText().toString();
                /*String id = idlET.getText().toString();*/
                String dept = deptET.getText().toString();
                String birthday = birthdayET.getText().toString();
                String nid = nidET.getText().toString();
                String phone = phnET.getText().toString();
                String present = presentET.getText().toString();
                String permanent = permanentT.getText().toString();

                String st_Id = studentRef.push().getKey();
                Student students = new Student(st_Id, name, email,dept,birthday, nid,phone,
                        present,permanent);
                studentRef.child(st_Id).setValue(students)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        
                    }
                });


            }
        });
    }

    public interface OnAddStudentSuccessListener{
        void onAddStudentSuccessful();
    }
}