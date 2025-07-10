package com.jobportal.jobapplication.Review.service;

import com.jobportal.jobapplication.Company.dto.CompanyResponseDto;
import com.jobportal.jobapplication.Company.entity.Company;
import com.jobportal.jobapplication.Company.mapper.CompanyMapper;
import com.jobportal.jobapplication.Company.service.CompanyService;
import com.jobportal.jobapplication.Review.dto.ReviewRequestDto;
import com.jobportal.jobapplication.Review.dto.ReviewResponseDto;
import com.jobportal.jobapplication.Review.entity.Review;
import com.jobportal.jobapplication.Review.mapper.ReviewMapper;
import com.jobportal.jobapplication.Review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;


    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<ReviewResponseDto> getAllReview(Long companyId) {
        return reviewRepository.findByCompanyId(companyId).stream().map(ReviewMapper::mapEntityToReviewRequestDto).toList();
    }


    @Override
    public ReviewResponseDto saveReview(ReviewRequestDto reviewRequestDto, Long companyId) {

        CompanyResponseDto companyDto = companyService.getCompanyById(companyId);
        Company company = CompanyMapper.mapCompanyResponseDtoToEntity(companyDto);
        reviewRequestDto.setCompany(company);
        Review review = ReviewMapper.mapReviewRequestDtoToEntity(reviewRequestDto);
        Review savedReview = reviewRepository.save(review);
        return ReviewMapper.mapEntityToReviewRequestDto(savedReview);
    }


    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public boolean updateReviewById(Review review, Long id) {
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            Review updatedReview = existingReview.get();
            updatedReview.setDescription(review.getDescription());
            updatedReview.setTitle(review.getTitle());
            updatedReview.setRating(review.getRating());
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletedReviewWithId(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
