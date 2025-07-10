package com.jobportal.jobapplication.Review.mapper;

import com.jobportal.jobapplication.Review.dto.ReviewRequestDto;
import com.jobportal.jobapplication.Review.dto.ReviewResponseDto;
import com.jobportal.jobapplication.Review.entity.Review;

public class ReviewMapper {
    public static Review mapReviewRequestDtoToEntity(ReviewRequestDto reviewRequestDto) {
        Review review = new Review();
        review.setTitle(reviewRequestDto.getTitle());
        review.setRating(reviewRequestDto.getRating());
        review.setDescription(reviewRequestDto.getDescription());
        review.setCompany(reviewRequestDto.getCompany());
        return review;
    }

    public static ReviewResponseDto mapEntityToReviewRequestDto(Review review) {
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setTitle(review.getTitle());
        reviewResponseDto.setRating(review.getRating());
        reviewResponseDto.setDescription(review.getDescription());
        reviewResponseDto.setCompany(review.getCompany());
        reviewResponseDto.setId(review.getId());
        return reviewResponseDto;
    }
}
