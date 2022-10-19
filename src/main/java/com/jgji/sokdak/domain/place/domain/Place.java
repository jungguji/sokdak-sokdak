package com.jgji.sokdak.domain.place.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "place")
@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private Address address;

    @Column(name = "category_id")
    private long categoryId;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<PlaceGrade> grades = new ArrayList<>();

    @Builder
    public Place(String name, Address address, long categoryId, List<PlaceGrade> grades) {
        this.name = name;
        this.address = address;
        this.categoryId = categoryId;
        this.grades = grades;
    }
}
