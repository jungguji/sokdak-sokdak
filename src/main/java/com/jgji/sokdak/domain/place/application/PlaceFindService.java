package com.jgji.sokdak.domain.place.application;

import com.jgji.sokdak.domain.place.domain.Address;
import com.jgji.sokdak.domain.place.domain.Place;
import com.jgji.sokdak.domain.place.domain.PlaceRepository;
import com.jgji.sokdak.domain.place.exception.AlreadyPlaceException;
import com.jgji.sokdak.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaceFindService {

    private final PlaceRepository placeRepository;

    public Place findByAddressZipAndAddressLocation(Place place) {
        Address address = place.getAddress();

        return this.placeRepository
            .findByAddressZipAndAddressLocation(address.getZip(), address.getLocation())
            .orElseThrow(EntityNotFoundException::new);
    }

    public void alreadyPlace(Place place) {
        try {
            this.findByAddressZipAndAddressLocation(place);
        } catch (EntityNotFoundException e) {
            return;
        }

        throw new AlreadyPlaceException();
    }

    public Place findById(long id) {
        return this.placeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
