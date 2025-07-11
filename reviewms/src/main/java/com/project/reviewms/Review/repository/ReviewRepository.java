package com.project.reviewms.Review.repository;

import com.project.reviewms.Review.dto.ReviewResponseDto;
import com.project.reviewms.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);
}
