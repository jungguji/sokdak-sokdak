package com.jgji.sokdak.domain.place.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "place_grade")
@Entity
public class PlaceGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "grade_total")
    private BigDecimal gradeTotal; // 그룹별 평점 평균

    @Column(name = "place_id", nullable = false)
    private long placeId;

    @Column(name = "group_id", nullable = false)
    private long groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Place place;

    @Builder
    public PlaceGrade(BigDecimal gradeTotal, long placeId, long groupId, Place place) {
        this.gradeTotal = gradeTotal;
        this.placeId = placeId;
        this.groupId = groupId;
        this.place = place;
    }
}
