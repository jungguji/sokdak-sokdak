package com.jgji.sokdak.domain.review.application;

import com.jgji.sokdak.domain.review.domain.Review;
import com.jgji.sokdak.domain.review.presentation.request.ReviewCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewFacade {

    private final ReviewSaveService reviewSaveService;

    public Review create(ReviewCreateRequest request) {
        return this.reviewSaveService.save(request.toEntity());
    }
}
