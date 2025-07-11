package com.project.joms.Job.service;


import com.project.joms.Job.dto.JobRequestDto;
import com.project.joms.Job.dto.JobResponseDto;
import com.project.joms.Job.entity.Job;
import com.project.joms.Job.exchange.Company;
import com.project.joms.Job.mapper.JobMapper;
import com.project.joms.Job.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;


    // private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobResponseDto saveJob(JobRequestDto jobRequestDto) {
        //  logger.info("Job has been created");
        // log.info("Job has been created");
        Job job = JobMapper.mapJobRequestDtoToEntity(jobRequestDto);
        Job savedJob = jobRepository.save(job);
        return JobMapper.mapEntityToJobRequestDto(savedJob);
    }

    @Override
    public List<JobResponseDto> fetchJobsList() {
        RestTemplate restTemplate = new RestTemplate();
        Company company = restTemplate.getForObject("http://localhost:8087/companies/1", Company.class);
        System.out.println("COMPANYYYYYY" + company.getName());
        System.out.println("COMPANYYYYYY" + company.getId());
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
        updateJob.setCompanyId(job.getCompanyId());
        return JobMapper.mapEntityToJobRequestDto(jobRepository.save(updateJob));
    }

    @Override
    public JobResponseDto fetchJobTitle(String jobTitle) {
        Job job = jobRepository.findByjobTitleIgnoreCase(jobTitle);
        return JobMapper.mapEntityToJobRequestDto(job);
    }


}
