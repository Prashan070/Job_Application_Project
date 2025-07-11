package com.project.reviewms.Review.service;

import com.project.reviewms.Review.dto.ReviewRequestDto;
import com.project.reviewms.Review.dto.ReviewResponseDto;
import com.project.reviewms.Review.entity.Review;
import com.project.reviewms.Review.mapper.ReviewMapper;
import com.project.reviewms.Review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewResponseDto> getAllReview(Long companyId) {
        return reviewRepository.findByCompanyId(companyId).stream().map(ReviewMapper::mapEntityToReviewRequestDto).toList();
    }

    @Override
    public ReviewResponseDto saveReview(ReviewRequestDto reviewRequestDto, Long companyId) {
        Review review = ReviewMapper.mapReviewRequestDtoToEntity(reviewRequestDto);
        review.setCompanyId(companyId);
        Review saved = reviewRepository.save(review);
        return ReviewMapper.mapEntityToReviewRequestDto(saved);

    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return Optional.empty();
    }


    @Override
    public boolean updateReviewById(Review review, Long id) {
        return false;
    }

    @Override
    public boolean deletedReviewWithId(Long id) {
        return false;
    }
}
