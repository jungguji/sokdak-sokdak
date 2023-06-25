package com.jgji.sokdak.domain.review.application;

import com.jgji.sokdak.domain.member.application.MemberFindService;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.review.application.dto.request.ReviewCreateRequest;
import com.jgji.sokdak.domain.review.application.dto.response.ReviewViewResponse;
import com.jgji.sokdak.domain.review.domain.Review;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewFacade {

    private final ReviewSaveService reviewSaveService;
    private final ReviewFindService reviewFindService;
    private final MemberFindService memberFindService;

    public Review create(ReviewCreateRequest request) {
        return this.reviewSaveService.save(request.toEntity());
    }

    public ReviewViewResponse view(long id) {
        Review review = this.reviewFindService.findById(id);
        Member writer = this.memberFindService.findById(review.getMemberId());

        return ReviewViewResponse.form(review, writer);
    }

    public List<ReviewViewResponse> findAllByMemberId(long memberId) {
        List<Review> reviews = this.reviewFindService.findMemberId(memberId);
        Member writer = this.memberFindService.findById(memberId);

        return reviews.stream()
            .map(r -> ReviewViewResponse.form(r, writer))
            .collect(Collectors.toList());
    }
}
