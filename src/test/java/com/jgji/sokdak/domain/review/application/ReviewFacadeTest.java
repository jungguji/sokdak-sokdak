package com.jgji.sokdak.domain.review.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

import com.jgji.sokdak.domain.review.domain.Review;
import com.jgji.sokdak.domain.review.presentation.request.ReviewCreateRequest;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReviewFacadeTest {

    @Autowired
    private ReviewFacade reviewFacade;


    @Test
    void create() {
        String content = "이 가게 최고";
        BigDecimal grade = new BigDecimal(4.231254);
        long memberId = 1;
        long placeId = 1;

        ReviewCreateRequest given = ReviewCreateRequest.builder()
            .content(content)
            .grade(grade)
            .memberId(memberId)
            .placeId(placeId)
            .build();

        Review review = this.reviewFacade.create(given);

        assertThat(is(review));
        assertThat(1).isEqualTo(review.getId());
        assertThat(4.3).isEqualTo(review.getGrade());
    }
}