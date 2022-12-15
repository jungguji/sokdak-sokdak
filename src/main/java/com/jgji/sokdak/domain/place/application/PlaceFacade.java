package com.jgji.sokdak.domain.place.application;

import com.jgji.sokdak.domain.place.application.response.PlaceViewResponse;
import com.jgji.sokdak.domain.place.domain.Place;
import com.jgji.sokdak.domain.place.application.request.PlaceCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PlaceFacade {

    private final PlaceService placeService;
    private final PlaceFindService placeFindService;

    public void create(PlaceCreateRequest request) {
        Place place = request.toEntity();

        this.placeService.save(place);
    }

    public PlaceViewResponse view(long id) {
        Place place = this.placeFindService.findById(id);

        return PlaceViewResponse.of(place);
    }
}
