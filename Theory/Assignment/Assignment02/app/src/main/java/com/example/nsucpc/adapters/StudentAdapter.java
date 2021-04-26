package com.example.nsucpc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nsucpc.R;
import com.example.nsucpc.models.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private Context context;
    private List<Student> studentList;


    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.student_row,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.name.setText(studentList.get(position).getName());
        holder.email.setText(studentList.get(position).getEmail());
        holder.pass.setText(studentList.get(position).getPass());
        holder.id.setText(studentList.get(position).getId());
        holder.dept.setText(studentList.get(position).getDept());
        holder.birthday.setText(studentList.get(position).getBirthday());
        holder.nid.setText(studentList.get(position).getNid());
        holder.phone.setText(studentList.get(position).getPhone());
        holder.present.setText(studentList.get(position).getPresentAddress());
        holder.permanent.setText(studentList.get(position).getPresentAddress());


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView name,email,pass,id,dept,birthday,nid,phone,present,permanent;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.row_name);
            email=itemView.findViewById(R.id.row_email);
            pass=itemView.findViewById(R.id.row_pass);
            id=itemView.findViewById(R.id.row_id);
            dept=itemView.findViewById(R.id.row_dept);
            birthday=itemView.findViewById(R.id.row_birthday);
            nid=itemView.findViewById(R.id.row_nid);
            phone=itemView.findViewById(R.id.row_phone);
            present=itemView.findViewById(R.id.row_presentAddress);
            permanent=itemView.findViewById(R.id.row_permanentAddress);
        }
    }


}
