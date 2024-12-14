package com.jobportal.jobapplication.service;

import com.jobportal.jobapplication.entity.Job;
import com.jobportal.jobapplication.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> fetchJobsList() {
        return jobRepository.findAll();
    }

    @Override
    public Job fetchJobById(Long jobId) {
        return jobRepository.findById(jobId).get();
    }

    @Override
    public void deleteJobById(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    @Override
    public Job updateJobById(Long jobId, Job job) {
        return null;
    }


}
