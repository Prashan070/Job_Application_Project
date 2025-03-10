package com.jobportal.jobapplication.Job.service;

import com.jobportal.jobapplication.Job.entity.Job;
import com.jobportal.jobapplication.Job.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Job> fetchJobById(Long jobId) {
        return jobRepository.findById(jobId);
    }

    @Override
    public boolean deleteJobById(Long jobId) {
        // logger.info("Job is deleted");
        log.info("Job is deleted");
        jobRepository.deleteById(jobId);
        return true;
    }

    @Override
    public boolean updateJobById(Long jobId, Job job) {
        Optional<Job> updateJob = jobRepository.findById(jobId);

        if (updateJob.isPresent()) {

            Job existingJob = updateJob.get();

            existingJob.setJobTitle(job.getJobTitle());
            existingJob.setJobDescription(job.getJobDescription());
            existingJob.setMaxSalary(job.getMaxSalary());
            existingJob.setMinSalary(job.getMinSalary());
            existingJob.setJobApplication(job.getJobApplication());

            jobRepository.save(existingJob);

            return true;
        }
        return false;
    }

    @Override
    public Job fetchJobTitle(String jobTitle) {
        return jobRepository.findByjobTitleIgnoreCase(jobTitle);
    }


}
