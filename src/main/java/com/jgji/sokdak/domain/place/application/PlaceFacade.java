package com.jgji.sokdak.domain.place.application;

import com.jgji.sokdak.domain.place.domain.Place;
import com.jgji.sokdak.domain.place.presentation.dto.PlaceCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PlaceFacade {

    private final PlaceSaveService placeSaveService;

    public void create(PlaceCreateRequest request) {
        Place place = request.toEntity();

        this.placeSaveService.save(place);
    }
}