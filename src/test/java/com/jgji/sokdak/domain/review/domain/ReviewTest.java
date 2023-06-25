package com.jgji.sokdak.domain.review.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReviewTest {

    @DisplayName(value = "이미지 없는 리뷰")
    @Test
    void test_no_image() {
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
        assertThat(0).isEqualTo(given.getImages().size());

    }

    @DisplayName(value = "이미지 있는 리뷰")
    @Test
    void test_image() {
        //given
        String content = "컨텐츠";
        BigDecimal grade = new BigDecimal(4.5);
        List<String> images = Arrays.asList(
            "test.png"
            , "test1.png"
            , "test2.png"
        );
        Review given = Review.builder()
            .content(content)
            .grade(grade)
            .memberId(1)
            .placeId(1)
            .images(images)
            .build();

        //then
        assertThat(is(given));
        assertThat(3).isEqualTo(given.getImages().size());
        assertThat("test.png").isEqualTo(given.getImages().get(0));
    }
}