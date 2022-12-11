package com.jgji.sokdak.domain.review.application;

import com.jgji.sokdak.domain.review.domain.Review;
import com.jgji.sokdak.domain.review.domain.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewSaveService {

    private final ReviewRepository reviewRepository;

    public Review save(Review review) {
        return this.reviewRepository.save(review);
    }
}
