package com.jgji.sokdak.domain.review.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

import com.jgji.sokdak.domain.review.domain.Review;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReviewFindServiceTest {

    @Autowired
    private ReviewFindService reviewFindService;

    @Test
    void findMyReviews() {

        List<Review> myReviews = this.reviewFindService.findMyReviews();

        assertThat(is(myReviews));
        assertThat(0).isEqualTo(myReviews.size());

    }
}