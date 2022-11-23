package com.jgji.sokdak.domain.place.application.dto;

import com.jgji.sokdak.domain.place.domain.Address;
import com.jgji.sokdak.domain.place.domain.Place;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExistPlaceCheckDTO {

    private String zip;
    private BigDecimal latitude;
    private BigDecimal longitude;

    @Builder
    public ExistPlaceCheckDTO(String zip, BigDecimal latitude, BigDecimal longitude) {
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static ExistPlaceCheckDTO from(Place place) {
        Address address = place.getAddress();

        return ExistPlaceCheckDTO.builder()
            .zip(address.getZip())
            .latitude(address.getLatitude())
            .longitude(address.getLongitude())
            .build();
    }
}
