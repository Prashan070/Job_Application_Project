package com.jobportal.jobapplication.service;

import com.jobportal.jobapplication.entity.Job;
import com.jobportal.jobapplication.repository.JobRepository;
import org.springframework.stereotype.Service;

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


}
