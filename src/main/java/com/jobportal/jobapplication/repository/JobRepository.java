package com.jobportal.jobapplication.repository;

import com.jobportal.jobapplication.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>{
}
