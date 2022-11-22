package com.jgji.sokdak.domain.place.domain;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Optional<Place> findByAddressZipAndAddressLatitudeAndAddressLongitude(String zip, BigDecimal latitude, BigDecimal longitude);
}
