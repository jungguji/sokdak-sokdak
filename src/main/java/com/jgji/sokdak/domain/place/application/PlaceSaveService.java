package com.jgji.sokdak.domain.place.application;

import com.jgji.sokdak.domain.place.domain.Address;
import com.jgji.sokdak.domain.place.domain.Place;
import com.jgji.sokdak.domain.place.domain.PlaceRepository;
import com.jgji.sokdak.domain.place.exception.AlreadyPlaceException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class PlaceSaveService {

    private final PlaceFindService placeFindService;

    private final PlaceRepository placeRepository;

    public Place save(Place place) {
        Address address = place.getAddress();

        List<Place> all = placeRepository.findAll();

        this.placeFindService
            .findByAddressZipAndAddressLatitudeAndAddressLongitude(address.getZip(), address.getLatitude(), address.getLongitude())
            .orElseThrow(() -> new AlreadyPlaceException());

        all = placeRepository.findAll();


        return this.placeRepository.save(place);
    }
}
