package com.jgji.sokdak.domain.review.application.dto.response;

import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.review.domain.Review;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewViewResponse {

    private String content;
    private Double grade;
    private List<String> images = new ArrayList<>();
    private List<String> comments = new ArrayList<>();
    private Writer writer;

    @Builder(access = AccessLevel.PRIVATE)
    private ReviewViewResponse(String content, Double grade, List<String> images, List<String> comments,
        Writer writer) {

        this.content = content;
        this.grade = grade;
        this.images = images;
        this.comments = comments;
        this.writer = writer;
    }

    public static ReviewViewResponse form(Review review, Member member) {
        return ReviewViewResponse.builder()
            .content(review.getContent())
            .grade(review.getGrade())
            .images(review.getImages())
            .writer(Writer.of(member))
            .build();
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static class Writer {
        private long id;
        private String nickname;

        @Builder(access = AccessLevel.PRIVATE)
        private Writer(long id, String nickname) {
            this.id = id;
            this.nickname = nickname;
        }

        public static Writer of(Member member) {
            return Writer.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .build();
        }
    }
}
