package com.jobportal.jobapplication.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String minSalary;
    private String maxSalary;
    private String jobApplication;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getJobApplication() {
        return jobApplication;
    }

    public void setJobApplication(String jobApplication) {
        this.jobApplication = jobApplication;
    }

    public Job(Long jobId, String jobTitle, String jobDescription, String minSalary, String maxSalary, String jobApplication) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.jobApplication = jobApplication;
    }

    public Job() {
    }
}
