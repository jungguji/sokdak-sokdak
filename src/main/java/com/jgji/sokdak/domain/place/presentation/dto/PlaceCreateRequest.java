package com.jgji.sokdak.domain.place.presentation.dto;

import com.jgji.sokdak.domain.place.domain.Place;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PlaceCreateRequest {

    private String name;
    @Valid
    private AddressForm address;
    private Long categoryId;

    @Builder
    public PlaceCreateRequest(String name, AddressForm address, Long categoryId) {
        this.name = name;
        this.address = address;
        this.categoryId = categoryId;
    }

    public Place toEntity() {
        return Place.builder()
            .name(this.name)
            .address(this.address.toEntity())
            .categoryId(this.categoryId)
            .build();
    }

}

