package com.jgji.sokdak.domain.place.domain;

import java.util.Optional;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Optional<Place> findByAddressZipAndAddressLocation(String zip, Point location);
}
