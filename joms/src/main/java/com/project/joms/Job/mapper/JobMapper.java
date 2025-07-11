package com.project.joms.Job.mapper;


import com.project.joms.Job.dto.JobRequestDto;
import com.project.joms.Job.dto.JobResponseDto;
import com.project.joms.Job.entity.Job;

public class JobMapper {

    public static Job mapJobRequestDtoToEntity(JobRequestDto jobRequestDto) {
        Job job = new Job();
        job.setJobDescription(jobRequestDto.getJobDescription());
        job.setJobTitle(jobRequestDto.getJobTitle());
        job.setJobApplication(jobRequestDto.getJobApplication());
        job.setMaxSalary(jobRequestDto.getMaxSalary());
        job.setMinSalary(jobRequestDto.getMinSalary());
        job.setCompanyId(jobRequestDto.getCompanyId());
        return job;
    }

    public static JobResponseDto mapEntityToJobRequestDto(Job job) {
        JobResponseDto jobResponseDto = new JobResponseDto();
        jobResponseDto.setJobDescription(job.getJobDescription());
        jobResponseDto.setJobTitle(job.getJobTitle());
        jobResponseDto.setJobApplication(job.getJobApplication());
        jobResponseDto.setMaxSalary(job.getMaxSalary());
        jobResponseDto.setMinSalary(job.getMinSalary());
        jobResponseDto.setCompanyId(job.getCompanyId());
        jobResponseDto.setJobId(job.getJobId());
        return jobResponseDto;
    }
}
