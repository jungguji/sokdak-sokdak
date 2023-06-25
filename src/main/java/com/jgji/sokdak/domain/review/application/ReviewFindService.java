package com.jgji.sokdak.domain.review.application;

import com.jgji.sokdak.domain.review.domain.Review;
import com.jgji.sokdak.domain.review.domain.ReviewRepository;
import com.jgji.sokdak.global.exception.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewFindService {

    private final ReviewRepository reviewRepository;

    public Review findById(long id) {
        return this.reviewRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
    }

    public List<Review> findMemberId(long memberId) {
        return this.reviewRepository.findByMemberId(memberId);
    }
}
