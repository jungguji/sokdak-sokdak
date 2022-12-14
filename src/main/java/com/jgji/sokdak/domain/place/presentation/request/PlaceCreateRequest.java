package com.jgji.sokdak.domain.place.presentation.request;

import com.jgji.sokdak.domain.place.domain.Place;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceCreateRequest {

    @NotEmpty
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

