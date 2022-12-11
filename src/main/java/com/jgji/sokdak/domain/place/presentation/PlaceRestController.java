package com.jgji.sokdak.domain.place.presentation;

import com.jgji.sokdak.domain.place.application.PlaceFacade;
import com.jgji.sokdak.domain.place.presentation.dto.PlaceCreateRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/place")
@RestController
public class PlaceRestController {

    private final PlaceFacade placeFacade;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody @Valid final PlaceCreateRequest request) {
        this.placeFacade.create(request);
    }

}
