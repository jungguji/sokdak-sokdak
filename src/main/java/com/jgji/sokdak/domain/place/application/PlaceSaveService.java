package com.jgji.sokdak.domain.place.application;

import com.jgji.sokdak.domain.place.application.dto.ExistPlaceCheckDTO;
import com.jgji.sokdak.domain.place.domain.Place;
import com.jgji.sokdak.domain.place.domain.PlaceRepository;
import com.jgji.sokdak.domain.place.exception.AlreadyPlaceException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Transactional
@RequiredArgsConstructor
@Service
public class PlaceSaveService {

    private final PlaceFindService placeFindService;

    private final PlaceRepository placeRepository;

    public Place save(Place place) {
        ExistPlaceCheckDTO placeCheckDTO = ExistPlaceCheckDTO.from(place);

        Place existPlace = this.placeFindService
            .findByAddressZipAndAddressLatitudeAndAddressLongitude(placeCheckDTO);

        List<Place> all = this.placeRepository.findAll();


        if (!ObjectUtils.isEmpty(existPlace)) {
            throw new AlreadyPlaceException();
        }

        return this.placeRepository.save(place);
    }
}
