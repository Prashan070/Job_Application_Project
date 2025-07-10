package com.jobportal.jobapplication.Job.service;

import com.jobportal.jobapplication.Job.dto.JobRequestDto;
import com.jobportal.jobapplication.Job.dto.JobResponseDto;
import com.jobportal.jobapplication.Job.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {


    public JobResponseDto saveJob(JobRequestDto jobRequestDto);

    public List<JobResponseDto> fetchJobsList();

    public JobResponseDto fetchJobById(Long jobId);

    public String deleteJobById(Long jobId);

    public JobResponseDto updateJobById(Long jobId, JobRequestDto jobRequestDto);

    public JobResponseDto fetchJobTitle(String jobTitle);
}
