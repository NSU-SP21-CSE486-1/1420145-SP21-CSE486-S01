package com.example.nsu_cpcfinal.Model;

public class Job {

    String jobName;
    String jobDes;
    String jobSalary;
    String jobStatus;

    public Job() {
    }

    public Job(String jobName, String jobDes, String jobSalary, String jobStatus) {
        this.jobName = jobName;
        this.jobDes = jobDes;
        this.jobSalary = jobSalary;
        this.jobStatus = jobStatus;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDes() {
        return jobDes;
    }

    public void setJobDes(String jobDes) {
        this.jobDes = jobDes;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
}
