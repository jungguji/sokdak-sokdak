package com.jgji.sokdak.domain.review.domain;

import com.jgji.sokdak.global.model.BaseEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "review")
@Entity
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    
    @Column(name = "content")
    private String content;

    @Column(name = "grade", nullable = false)
    private BigDecimal grade;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "place_id", nullable = false)
    private long placeId;

    @Embedded
    private ReviewImages reviewImages;

    @Builder
    public Review(String content, BigDecimal grade, long memberId, long placeId, List<String> images) {
        this.content = content;
        this.grade = grade;
        this.memberId = memberId;
        this.placeId = placeId;
        this.reviewImages = new ReviewImages(convertToReviewImages(images));
    }

    private List<ReviewImage> convertToReviewImages(List<String> images) {
        List<ReviewImage> reviewImages = new ArrayList<>();

        if (!ObjectUtils.isEmpty(images)) {
            reviewImages = images
                .stream()
                .map(image -> ReviewImage.builder()
                    .review(this)
                    .image(image)
                    .build())
                .collect(Collectors.toList());
        }

        return reviewImages;
    }
}
