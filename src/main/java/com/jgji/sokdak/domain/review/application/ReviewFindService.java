package com.jgji.sokdak.domain.review.application;

import com.jgji.sokdak.domain.review.domain.Review;
import com.jgji.sokdak.domain.review.domain.ReviewRepository;
import com.jgji.sokdak.domain.review.infrastructure.ReviewCustomRepository;
import com.jgji.sokdak.global.exception.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewFindService {

    private final ReviewRepository reviewRepository;
    private final ReviewCustomRepository reviewCustomRepository;

    public Review findById(long id) {
        return this.reviewRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
    }

    public List<Review> findMyReviews() {
        return this.reviewCustomRepository.myReviews();
    }
}
