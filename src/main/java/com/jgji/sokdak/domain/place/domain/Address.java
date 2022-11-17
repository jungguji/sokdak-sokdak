package com.jgji.sokdak.domain.place.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @Column(name = "road")
    private String road;

    @Column(name = "jibun")
    private String jibun;

    @Column(name = "zip")
    private String zip;

    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

    @Builder
    public Address(String road, String jibun, String zip, BigDecimal latitude, BigDecimal longitude) {
        this.road = road;
        this.jibun = jibun;
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
