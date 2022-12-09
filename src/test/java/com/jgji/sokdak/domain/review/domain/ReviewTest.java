package com.jgji.sokdak.domain.review.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ReviewTest {

    @Test
    void test() {
        //given
        String content = "컨텐츠";
        BigDecimal grade = new BigDecimal(4.5);
        Review given = Review.builder()
            .content(content)
            .grade(grade)
            .memberId(1)
            .placeId(1)
            .build();

        //then
        assertThat(is(given));
    }
}