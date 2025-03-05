package com.jobportal.jobapplication.Review.repository;

import com.jobportal.jobapplication.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {


    List<Review> findByCompanyId(Long companyId);
}
