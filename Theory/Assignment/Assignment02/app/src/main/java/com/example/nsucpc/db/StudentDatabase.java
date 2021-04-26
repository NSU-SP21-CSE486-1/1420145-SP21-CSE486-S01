package com.example.nsucpc.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nsucpc.daos.StudentDao;
import com.example.nsucpc.models.Student;

@Database(entities = {Student.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase studentDB;
    public abstract StudentDao getStudentDao();

    public static StudentDatabase getInstance(Context context){
        if (studentDB !=null){
            return studentDB;
        }
        studentDB= Room.databaseBuilder(context,StudentDatabase.class,"student_db")
                .allowMainThreadQueries().build();
        return studentDB;
    }


}
