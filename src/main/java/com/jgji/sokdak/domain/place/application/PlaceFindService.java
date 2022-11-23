package com.jgji.sokdak.domain.place.application;

import com.jgji.sokdak.domain.place.domain.Place;
import com.jgji.sokdak.domain.place.domain.PlaceRepository;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaceFindService {

    private final PlaceRepository placeRepository;

    public Optional<Place> findByAddressZipAndAddressLatitudeAndAddressLongitude(String zip, BigDecimal latitude,
        BigDecimal longitude) {
        return placeRepository.findByAddressZipAndAddressLatitudeAndAddressLongitude(zip, latitude, longitude);
    }
}
