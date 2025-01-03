package com.jobportal.jobapplication.service;

import com.jobportal.jobapplication.entity.Job;
import com.jobportal.jobapplication.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

   // private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job saveJob(Job job) {
      //  logger.info("Job has been created");
        log.info("Job has been created");
        return jobRepository.save(job);
    }

    @Override
    public List<Job> fetchJobsList() {
        return jobRepository.findAll();
    }

    @Override
    public Job fetchJobById(Long jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }

    @Override
    public void deleteJobById(Long jobId) {
       // logger.info("Job is deleted");
        log.info("Job is deleted");
        jobRepository.deleteById(jobId);
    }

    @Override
    public Job updateJobById(Long jobId, Job job) {
        Job jobDB = jobRepository.findById(jobId).get();

        if (Objects.nonNull(job.getJobTitle()) && !"".equalsIgnoreCase(job.getJobTitle())) {
            jobDB.setJobTitle(job.getJobTitle());
        }
        if (Objects.nonNull(job.getMinSalary()) && !"".equalsIgnoreCase(job.getMinSalary())) {
            jobDB.setMaxSalary(job.getMinSalary());
        }
        if (Objects.nonNull(job.getMaxSalary()) && !"".equalsIgnoreCase(job.getMaxSalary())) {
            jobDB.setMaxSalary(job.getMaxSalary());
        }
        return jobRepository.save(jobDB);
    }

    @Override
    public Job fetchJobTitle(String jobTitle) {
        return jobRepository.findByjobTitleIgnoreCase(jobTitle);
    }


}
