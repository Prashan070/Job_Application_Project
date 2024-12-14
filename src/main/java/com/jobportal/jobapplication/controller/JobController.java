package com.jobportal.jobapplication.controller;


import com.jobportal.jobapplication.entity.Job;
import com.jobportal.jobapplication.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    private JobService jobService;

    public Job saveJob(Job job) {
        return jobService.saveJob(job);
    }


}
