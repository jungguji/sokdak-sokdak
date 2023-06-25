package com.jgji.sokdak.domain.place.application;

import com.jgji.sokdak.domain.place.domain.Place;
import com.jgji.sokdak.domain.place.domain.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class PlaceService {

    private final PlaceFindService placeFindService;

    private final PlaceRepository placeRepository;

    public Place save(Place place) {
        this.placeFindService.alreadyPlace(place);

        return this.placeRepository.save(place);
    }
}
