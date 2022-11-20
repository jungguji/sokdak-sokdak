package com.jgji.sokdak.domain.place.application;

import com.jgji.sokdak.domain.place.application.dto.ExistPlaceCheckDTO;
import com.jgji.sokdak.domain.place.domain.Place;
import com.jgji.sokdak.domain.place.domain.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaceFindService {

    private final PlaceRepository placeRepository;

    public Place findByAddressZipAndAddressLatitudeAndAddressLongitude(ExistPlaceCheckDTO existPlaceCheckDTO) {
        return placeRepository.findByAddressZipAndAddressLatitudeAndAddressLongitude(existPlaceCheckDTO.getZip(),
            existPlaceCheckDTO.getLatitude(), existPlaceCheckDTO.getLongitude());
    }
}
