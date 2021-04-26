package com.example.nsucpc.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nsucpc.models.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    long insertNewStudent(Student student);
    @Delete
    int deletStudent(Student student);

    @Update
    int updateStudent(Student student);

    @Query("select *from student_Table")
    List<Student> getAllStudents();

}
