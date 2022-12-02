package com.jgji.sokdak.domain.place.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.jgji.sokdak.domain.place.domain.PlaceRepository;
import com.jgji.sokdak.domain.place.exception.AlreadyPlaceException;
import com.jgji.sokdak.domain.place.presentation.dto.AddressForm;
import com.jgji.sokdak.domain.place.presentation.dto.PlaceCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaceFacadeTest {

    @Autowired
    private PlaceFacade placeFacade;

    @Autowired
    private PlaceRepository placeRepository;

    @Test
    void create() {
        //given
        String zipCode = "01006";
        String latitude = "19";
        String longitude = "2";

        AddressForm address = AddressForm.builder()
            .jibun("지번 서울시")
            .road("도로명 서울시")
            .zip(zipCode)
            .latitude(latitude)
            .longitude(longitude)
            .build();

        PlaceCreateRequest when = PlaceCreateRequest.builder()
            .name("우리집")
            .categoryId(null)
            .address(address)
            .build();

        //when
        this.placeFacade.create(when);

        //then
        assertThat(this.placeRepository.count()).isEqualTo(2);
    }

    @DisplayName(value = "이미 있는 장소 또 생성 시 Exception")
    @Test
    void create_throw() {
        //given
        String zipCode = "03119";
        String latitude = "37.5711389";
        String longitude = "127.0095452";

        AddressForm address = AddressForm.builder()
            .jibun("하하호호")
            .road("숭례문인지흥인지문인지")
            .zip(zipCode)
            .latitude(latitude)
            .longitude(longitude)
            .build();


        PlaceCreateRequest when = PlaceCreateRequest.builder()
            .name("우리집")
            .categoryId(null)
            .address(address)
            .build();

        //when
        assertThrows(AlreadyPlaceException.class, () -> this.placeFacade.create(when));
    }
}