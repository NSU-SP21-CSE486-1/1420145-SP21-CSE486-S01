package com.example.nsucpc_3;

public class Student {
    private String stID;
    private String stName;
    private String stemail;
    private String stdtpt;
    private String stbirthday;
    private String stnid;
    private String stphone;
    private String stpresent;
    private String stpermanent;


    public Student() {
    }

    public Student(String stID, String stName, String stemail, String stdtpt, String stbirthday, String stnid,
                   String stphone, String stpresent, String stpermanent) {
        this.stID = stID;
        this.stName = stName;
        this.stemail = stemail;
        this.stdtpt = stdtpt;
        this.stbirthday = stbirthday;
        this.stnid = stnid;
        this.stphone = stphone;
        this.stpresent = stpresent;
        this.stpermanent = stpermanent;
    }

    public String getStID() {
        return stID;
    }

    public void setStID(String stID) {
        this.stID = stID;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStemail() {
        return stemail;
    }

    public void setStemail(String stemail) {
        this.stemail = stemail;
    }

    public String getStdtpt() {
        return stdtpt;
    }

    public void setStdtpt(String stdtpt) {
        this.stdtpt = stdtpt;
    }

    public String getStbirthday() {
        return stbirthday;
    }

    public void setStbirthday(String stbirthday) {
        this.stbirthday = stbirthday;
    }

    public String getStnid() {
        return stnid;
    }

    public void setStnid(String stnid) {
        this.stnid = stnid;
    }

    public String getStphone() {
        return stphone;
    }

    public void setStphone(String stphone) {
        this.stphone = stphone;
    }

    public String getStpresent() {
        return stpresent;
    }

    public void setStpresent(String stpresent) {
        this.stpresent = stpresent;
    }

    public String getStpermanent() {
        return stpermanent;
    }

    public void setStpermanent(String stpermanent) {
        this.stpermanent = stpermanent;
    }
}


