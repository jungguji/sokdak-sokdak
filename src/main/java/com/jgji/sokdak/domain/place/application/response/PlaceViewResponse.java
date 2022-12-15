package com.jgji.sokdak.domain.place.application.response;

import com.jgji.sokdak.domain.place.domain.Address;
import com.jgji.sokdak.domain.place.domain.Place;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceViewResponse {

    private long id;
    private String name;
    private AddressResponse addressResponse;
    private Double grade;

    @Builder
    public PlaceViewResponse(long id, String name, AddressResponse addressResponse, Double grade) {
        this.id = id;
        this.name = name;
        this.addressResponse = addressResponse;
        this.grade = grade;
    }

    public static PlaceViewResponse of(Place place) {
        return PlaceViewResponse.builder()
            .id(place.getId())
            .name(place.getName())
            .addressResponse(AddressResponse.of(place.getAddress()))
            .grade(place.getGrade())
            .build();
    }

    static class AddressResponse {

        private String road;
        private String jibun;
        private String zip;

        @Builder
        private AddressResponse(String road, String jibun, String zip) {
            this.road = road;
            this.jibun = jibun;
            this.zip = zip;
        }

        public static AddressResponse of(Address address) {
            return AddressResponse.builder()
                .road(address.getRoad())
                .jibun(address.getJibun())
                .zip(address.getZip())
                .build();
        }
    }

    static class Category {

        private long id;
        private String name;

        @Builder
        public Category(long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
