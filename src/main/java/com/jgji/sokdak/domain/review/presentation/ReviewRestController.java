package com.jgji.sokdak.domain.review.presentation;

import com.jgji.sokdak.domain.review.application.ReviewFacade;
import com.jgji.sokdak.domain.review.application.dto.request.ReviewCreateRequest;
import com.jgji.sokdak.domain.review.application.dto.response.ReviewViewResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReviewRestController {

    private final ReviewFacade reviewFacade;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/review", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long create(@RequestBody ReviewCreateRequest request) {
        return this.reviewFacade.create(request).getId();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/review/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReviewViewResponse create(@PathVariable("id") long id) {
        return this.reviewFacade.view(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/review/my", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReviewViewResponse> myReviews(long memberId) {
        return this.reviewFacade.findAllByMemberId(memberId);
    }
}
