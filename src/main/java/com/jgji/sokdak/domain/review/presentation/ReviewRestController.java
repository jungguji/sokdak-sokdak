package com.jgji.sokdak.domain.review.presentation;

import com.jgji.sokdak.domain.review.application.ReviewFacade;
import com.jgji.sokdak.domain.review.presentation.request.ReviewCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReviewRestController {

    private final ReviewFacade reviewFacade;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/review", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long create(ReviewCreateRequest request) {
        return this.reviewFacade.create(request).getId();
    }
}
