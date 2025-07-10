package com.jobportal.jobapplication.Job.mapper;


import com.jobportal.jobapplication.Job.dto.JobRequestDto;
import com.jobportal.jobapplication.Job.dto.JobResponseDto;
import com.jobportal.jobapplication.Job.entity.Job;

public class JobMapper {

    public static Job mapJobRequestDtoToEntity(JobRequestDto jobRequestDto) {
        Job job = new Job();
        job.setJobDescription(jobRequestDto.getJobDescription());
        job.setJobTitle(jobRequestDto.getJobTitle());
        job.setJobApplication(jobRequestDto.getJobApplication());
        job.setMaxSalary(jobRequestDto.getMaxSalary());
        job.setMinSalary(jobRequestDto.getMinSalary());
        job.setCompany(jobRequestDto.getCompany());
        return job;
    }

    public static JobResponseDto mapEntityToJobRequestDto(Job job) {
        JobResponseDto jobResponseDto = new JobResponseDto();
        jobResponseDto.setJobDescription(job.getJobDescription());
        jobResponseDto.setJobTitle(job.getJobTitle());
        jobResponseDto.setJobApplication(job.getJobApplication());
        jobResponseDto.setMaxSalary(job.getMaxSalary());
        jobResponseDto.setMinSalary(job.getMinSalary());
        jobResponseDto.setCompany(job.getCompany());
        jobResponseDto.setJobId(job.getJobId());
        return jobResponseDto;
    }
}
