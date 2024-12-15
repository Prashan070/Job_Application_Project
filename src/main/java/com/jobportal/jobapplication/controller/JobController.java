package com.jobportal.jobapplication.controller;


import com.jobportal.jobapplication.entity.Job;
import com.jobportal.jobapplication.service.JobService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    private final Logger logger = LoggerFactory.getLogger(JobController.class);

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/jobs")
    public Job saveJob(@Valid @RequestBody Job job) {
        logger.info("Inside saveJob of JobController");
        return jobService.saveJob(job);
    }

    @GetMapping("/jobs")
    public List<Job> fetchJobsList() {
        logger.info("Inside fetchJobsList of JobController");
        return jobService.fetchJobsList();
    }

    @GetMapping("/jobs/{id}")
    public Job fetchJobById(@PathVariable("id") Long jobId) {
        return jobService.fetchJobById(jobId);
    }

    @DeleteMapping("jobs/{id}")
    public String deleteJobById(@PathVariable("id") Long jobId) {
        jobService.deleteJobById(jobId);
        return "Job deleted successfully";
    }


    @PutMapping("jobs/{id}")
    public Job updateJobById(@PathVariable("id") Long jobId, @RequestBody Job job){
        return jobService.updateJobById(jobId,job);
    }

    @GetMapping("jobs/jobTitle/{jobTitle}")
    public Job fetchJobTitle(@PathVariable("jobTitle") String jobTitle){
        return jobService.fetchJobTitle(jobTitle);
    }


}
