package com.example.nsucpc.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_Table")

public class Student {
    @PrimaryKey(autoGenerate = true)
    private long intial_id;
    private String name;
    private String email;
    private String pass;
    private String id;
    private String dept;
    private String birthday;
    private String nid;
    private String phone;
    private String presentAddress;
    private String permanentAddress;

    public Student(String name, String email, String pass,
                   String id, String dept, String birthday,
                   String nid, String phone,
                   String presentAddress, String permanentAddress) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.id = id;
        this.dept = dept;
        this.birthday = birthday;
        this.nid = nid;
        this.phone = phone;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
    }
@Ignore
    public Student(long intial_id, String name, String email, String pass, String id, String dept,
                   String birthday, String nid, String phone,
                   String presentAddress, String permanentAddress) {
        this(name,email,pass,id,dept,birthday,nid,phone,presentAddress,permanentAddress);
        this.intial_id = intial_id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public long getIntial_id() {
        return intial_id;
    }

    public void setIntial_id(long intial_id) {
        this.intial_id = intial_id;
    }
}
