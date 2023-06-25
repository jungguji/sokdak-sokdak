package com.jgji.sokdak.domain.review.application.dto.request;

import com.jgji.sokdak.domain.review.domain.Review;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewCreateRequest {

    private String content;

    @NotNull(message = "평점은 필수입니다.")
    private BigDecimal grade;

    @NotNull(message = "장소를 선택해주세요.")
    private Long placeId;

    @NotNull
    private Long memberId;

    private List<String> images = new ArrayList<>();

    @Builder
    public ReviewCreateRequest(String content,
        @NotNull(message = "평점은 필수입니다.") BigDecimal grade,
        @NotNull(message = "장소를 선택해주세요.") Long placeId, @NotNull Long memberId, List<String> images) {
        this.content = content;
        this.grade = grade;
        this.placeId = placeId;
        this.memberId = memberId;
        this.images = images;
    }

    public Review toEntity() {
        return Review.builder()
            .content(this.content)
            .grade(this.grade.setScale(1, RoundingMode.CEILING))
            .placeId(this.placeId)
            .memberId(this.memberId)
            .images(images)
            .build();
    }
}
