package com.jobportal.jobapplication.Job.service;

import com.jobportal.jobapplication.Company.entity.Company;
import com.jobportal.jobapplication.Company.repository.CompanyRepository;
import com.jobportal.jobapplication.Job.dto.JobRequestDto;
import com.jobportal.jobapplication.Job.dto.JobResponseDto;
import com.jobportal.jobapplication.Job.entity.Job;
import com.jobportal.jobapplication.Job.mapper.JobMapper;
import com.jobportal.jobapplication.Job.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private CompanyRepository companyRepository;

    // private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    @Autowired
    public JobServiceImpl(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public JobResponseDto saveJob(JobRequestDto jobRequestDto) {
        //  logger.info("Job has been created");
        log.info("Job has been created");
        Job job = JobMapper.mapJobRequestDtoToEntity(jobRequestDto);
        Job savedJob = jobRepository.save(job);
        return JobMapper.mapEntityToJobRequestDto(savedJob);
    }

    @Override
    public List<JobResponseDto> fetchJobsList() {
        return jobRepository.findAll().stream().map(JobMapper::mapEntityToJobRequestDto).toList();
    }

    @Override
    public JobResponseDto fetchJobById(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("not found"));
        return JobMapper.mapEntityToJobRequestDto(job);
    }

    @Override
    public String deleteJobById(Long jobId) {
        // logger.info("Job is deleted");
        // log.info("Job is deleted");
        jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Not Found"));
        jobRepository.deleteById(jobId);
        return "Deleted";
    }

    @Override
    public JobResponseDto updateJobById(Long jobId, JobRequestDto jobRequestDto) {
        Job updateJob = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("not found"));
        Job job = JobMapper.mapJobRequestDtoToEntity(jobRequestDto);
        updateJob.setJobApplication(job.getJobApplication());
        updateJob.setJobDescription(job.getJobDescription());
        updateJob.setJobTitle(job.getJobTitle());
        updateJob.setJobId(job.getJobId());
        updateJob.setMinSalary(job.getMinSalary());
        updateJob.setMaxSalary(job.getMaxSalary());
        updateJob.setCompany(job.getCompany());
        return JobMapper.mapEntityToJobRequestDto(jobRepository.save(updateJob));
    }

    @Override
    public JobResponseDto fetchJobTitle(String jobTitle) {
        Job job = jobRepository.findByjobTitleIgnoreCase(jobTitle);
        return JobMapper.mapEntityToJobRequestDto(job);
    }


}
