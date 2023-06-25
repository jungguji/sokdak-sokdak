package com.jgji.sokdak.domain.place.domain;

import com.jgji.sokdak.domain.place.domain.grade.PlaceGrades;
import com.jgji.sokdak.global.model.BaseEntity;
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

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "place")
@Entity
public class Place extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private Address address;

    @Column(name = "category_id")
    private Long categoryId;

    @Embedded
    private PlaceGrades placeGrades;

    @Builder
    public Place(String name, Address address, Long categoryId, PlaceGrades placeGrades) {
        this.name = name;
        this.address = address;
        this.categoryId = categoryId;
        this.placeGrades = placeGrades;
    }

    public Double getGrade() {
        return this.getPlaceGrades().getGrade();
    }
}
