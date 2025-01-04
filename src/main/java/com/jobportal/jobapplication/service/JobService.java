package com.jobportal.jobapplication.service;

import com.jobportal.jobapplication.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {


    public Job saveJob(Job job);

    public List<Job> fetchJobsList();

    public Optional<Job> fetchJobById(Long jobId);

    public boolean deleteJobById(Long jobId);

    public  Job updateJobById(Long jobId, Job job);

     public Job fetchJobTitle(String jobTitle);
}
