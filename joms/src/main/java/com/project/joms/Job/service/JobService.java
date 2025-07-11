package com.project.joms.Job.service;


import com.project.joms.Job.dto.JobRequestDto;
import com.project.joms.Job.dto.JobResponseDto;

import java.util.List;

public interface JobService {


    public JobResponseDto saveJob(JobRequestDto jobRequestDto);

    public List<JobResponseDto> fetchJobsList();

    public JobResponseDto fetchJobById(Long jobId);

    public String deleteJobById(Long jobId);

    public JobResponseDto updateJobById(Long jobId, JobRequestDto jobRequestDto);

    public JobResponseDto fetchJobTitle(String jobTitle);
}
