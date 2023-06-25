package com.jgji.sokdak.domain.review.infrastructure;

import com.jgji.sokdak.domain.review.domain.Review;
import java.util.List;


public interface ReviewCustomRepository {

    List<Review> myReviews();
}
