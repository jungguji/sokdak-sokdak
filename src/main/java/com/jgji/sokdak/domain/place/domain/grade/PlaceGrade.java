package com.jgji.sokdak.domain.place.domain.grade;

import com.jgji.sokdak.domain.place.domain.Place;
import com.jgji.sokdak.global.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "place_grade")
@Entity
public class PlaceGrade extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "grade_total", columnDefinition = "DECIMAL(2,1)")
    private BigDecimal gradeTotal; // 그룹별 평점 평균

    @Column(name = "group_id", nullable = false)
    private long groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @Builder
    public PlaceGrade(BigDecimal gradeTotal, long groupId, Place place) {
        this.gradeTotal = gradeTotal;
        this.groupId = groupId;
        this.place = place;
    }

    public Double getGradeTotal() {
        return this.gradeTotal.doubleValue();
    }
}
