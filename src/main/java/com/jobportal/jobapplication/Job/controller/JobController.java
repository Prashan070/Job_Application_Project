package com.jobportal.jobapplication.Job.controller;


import com.jobportal.jobapplication.Job.entity.Job;
import com.jobportal.jobapplication.Job.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {

    private JobService jobService;


    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/jobs")
    public ResponseEntity<Job> saveJob(@Valid @RequestBody Job job) {
        return new ResponseEntity<>(jobService.saveJob(job), HttpStatus.OK);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> fetchJobsList() {
        return new ResponseEntity<>(jobService.fetchJobsList(), HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> fetchJobById(@PathVariable("id") Long jobId) {

        Optional<Job> job = jobService.fetchJobById(jobId);

        if (job.isPresent()) {
            return new ResponseEntity<>(job.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable("id") Long jobId) {
        boolean isDeleted = jobService.deleteJobById(jobId);
        if (isDeleted) {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("jobs/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable("id") Long jobId, @RequestBody Job job) {
        boolean isUpdated =  jobService.updateJobById(jobId, job);
        if(isUpdated){
            return new ResponseEntity<>("Job has been updated",HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("jobs/jobTitle/{jobTitle}")
    public Job fetchJobTitle(@PathVariable("jobTitle") String jobTitle) {
        return jobService.fetchJobTitle(jobTitle);
    }


}
