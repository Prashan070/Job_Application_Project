package com.project.reviewms.Review.controller;


import com.project.reviewms.Review.dto.ReviewRequestDto;
import com.project.reviewms.Review.dto.ReviewResponseDto;
import com.project.reviewms.Review.entity.Review;
import com.project.reviewms.Review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDto>> getAllReview(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReview(companyId),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ReviewResponseDto> saveReview(@RequestBody ReviewRequestDto reviewRequestDto, @RequestParam Long companyId) {
       return new ResponseEntity<>(reviewService.saveReview(reviewRequestDto,companyId),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") Long id) {
        Optional<Review> isReviewAvaiable = reviewService.getReviewById(id);
        if (isReviewAvaiable.isPresent()) {
            return new ResponseEntity<>(isReviewAvaiable.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateReviewById(@RequestBody Review review, @PathVariable Long id) {
        boolean isUpdated = reviewService.updateReviewById(review, id);
        if (isUpdated) {
            return new ResponseEntity<>("Review has been updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletedReviewWithId(@PathVariable Long id) {
        boolean isDeleted = reviewService.deletedReviewWithId(id);
        if (isDeleted) {
            return new ResponseEntity<>("Review has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
