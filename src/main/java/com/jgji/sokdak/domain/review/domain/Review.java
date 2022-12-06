package com.jgji.sokdak.domain.review.domain;

import com.jgji.sokdak.global.model.BaseEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "grade", nullable = false, columnDefinition = "DECIMAL(2,1)")
    private BigDecimal grade;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "place_id", nullable = false)
    private long placeId;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImages = new ArrayList<>();

    @Builder
    public Review(String content, BigDecimal grade, long memberId, long placeId, List<ReviewImage> reviewImages) {
        this.content = content;
        this.grade = grade;
        this.memberId = memberId;
        this.placeId = placeId;
        this.reviewImages = reviewImages;
    }
}
