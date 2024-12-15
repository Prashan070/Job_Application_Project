package com.jobportal.jobapplication.repository;

import com.jobportal.jobapplication.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    public Job findByjobTitle(String jobTitle);


    public Job findByjobTitleIgnoreCase(String jobTitle);

}
