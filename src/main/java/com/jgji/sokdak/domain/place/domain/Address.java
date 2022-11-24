package com.jgji.sokdak.domain.place.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @Column(name = "road")
    private String road;

    @Column(name = "jibun")
    private String jibun;

    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "location", nullable = false, columnDefinition = "geometry")
    private Point location;

    @Builder
    public Address(String road, String jibun, String zip, Point location) {
        this.road = road;
        this.jibun = jibun;
        this.zip = zip;
        this.location = location;
    }
}
