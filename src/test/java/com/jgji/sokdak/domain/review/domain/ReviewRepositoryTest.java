package com.jgji.sokdak.domain.review.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void test() {

        Review givenReview = Review.builder()
            .content("test")
            .grade(new BigDecimal(4.5))
            .memberId(1)
            .placeId(1)
            .build();

        ReviewImage imageee = ReviewImage.builder()
            .image("imageee")
            .review(givenReview)
            .build();

        this.reviewRepository.save(givenReview);

        assertThat(is(givenReview.getReviewImages()));
    }
}