package com.project.joms.Job.controller;


import com.project.joms.Job.dto.JobRequestDto;
import com.project.joms.Job.dto.JobResponseDto;
import com.project.joms.Job.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;


    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobResponseDto> saveJob(@Valid @RequestBody JobRequestDto jobRequestDto) {
        return new ResponseEntity<>(jobService.saveJob(jobRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<JobResponseDto>> fetchJobsList() {

        return new ResponseEntity<>(jobService.fetchJobsList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDto> fetchJobById(@PathVariable("id") Long jobId) {
        return new ResponseEntity<>(jobService.fetchJobById(jobId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable("id") Long jobId) {
        return new ResponseEntity<>(jobService.deleteJobById(jobId), HttpStatus.OK);
    }


    @GetMapping("jobs/{jobTitle}")
    public ResponseEntity<JobResponseDto> fetchJobTitle(@PathVariable("jobTitle") String jobTitle) {
        return new ResponseEntity<>(jobService.fetchJobTitle(jobTitle), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<JobResponseDto> updateJobById(@PathVariable("id") Long jobId, @RequestBody JobRequestDto jobRequestDto) {
        return new ResponseEntity<>(jobService.updateJobById(jobId, jobRequestDto), HttpStatus.OK);
    }

}
