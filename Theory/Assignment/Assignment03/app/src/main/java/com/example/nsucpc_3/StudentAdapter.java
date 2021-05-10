package com.example.nsucpc_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

    private Context context;
    private List<Student> studentList;

    private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private DatabaseReference userIdRef;
    private DatabaseReference studentRef;
    private FirebaseUser currentUser;

    public StudentAdapter(Context context, List<Student> studentList) {

        this.context = context;
        this.studentList = studentList;
        rootRef = FirebaseDatabase.getInstance().getReference();
        userRef = rootRef.child("Users");
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        userIdRef = userRef.child(currentUser.getUid());
        studentRef = userIdRef.child("Students");
    }



    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.student_row, parent, false);

        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.nameTV.setText(studentList.get(position).getStName());
        holder.emailTV.setText(studentList.get(position).getStemail());
        /*holder.idTV.setText(studentList.get(position).getStid());*/
        holder.deptTV.setText(studentList.get(position).getStdtpt());
        holder.birthdayTV.setText(studentList.get(position).getStbirthday());
        holder.nidTV.setText(studentList.get(position).getStnid());
        holder.phoneTV.setText(studentList.get(position).getStphone());
        holder.presentTV.setText(studentList.get(position).getStpresent());
        holder.permanentTV.setText(studentList.get(position).getStpermanent());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV,emailTV,idTV,deptTV,birthdayTV,nidTV,phoneTV,presentTV,permanentTV;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.row_name);
            emailTV=itemView.findViewById(R.id.row_email);
            idTV=itemView.findViewById(R.id.row_id);
            deptTV=itemView.findViewById(R.id.row_dept);
            birthdayTV=itemView.findViewById(R.id.row_birthday);
            nidTV=itemView.findViewById(R.id.row_nid);
            phoneTV=itemView.findViewById(R.id.row_phone);
            presentTV=itemView.findViewById(R.id.row_present);
            permanentTV=itemView.findViewById(R.id.row_permanent);
        }
    }


}
