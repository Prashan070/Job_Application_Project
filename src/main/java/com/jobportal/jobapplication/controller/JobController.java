package com.jobportal.jobapplication.controller;


import com.jobportal.jobapplication.entity.Job;
import com.jobportal.jobapplication.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;


    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/jobs")
    public Job saveJob(@Valid @RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @GetMapping("/jobs")
    public List<Job> fetchJobsList() {
        return jobService.fetchJobsList();
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> fetchJobById(@PathVariable("id") Long jobId) {

        Job job = jobService.fetchJobById(jobId);
        if (job != null) {
            return ResponseEntity.ok(job);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("jobs/{id}")
    public String deleteJobById(@PathVariable("id") Long jobId) {
        jobService.deleteJobById(jobId);
        return "Job deleted successfully";
    }


    @PutMapping("jobs/{id}")
    public Job updateJobById(@PathVariable("id") Long jobId, @RequestBody Job job) {
        return jobService.updateJobById(jobId, job);
    }

    @GetMapping("jobs/jobTitle/{jobTitle}")
    public Job fetchJobTitle(@PathVariable("jobTitle") String jobTitle) {
        return jobService.fetchJobTitle(jobTitle);
    }


}
