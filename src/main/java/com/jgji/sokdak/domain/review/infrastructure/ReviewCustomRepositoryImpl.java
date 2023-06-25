package com.jgji.sokdak.domain.review.infrastructure;

import com.jgji.sokdak.domain.review.domain.Review;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewCustomRepositoryImpl implements ReviewCustomRepository {

    @Override
    public List<Review> myReviews() {
        return new ArrayList<>();
    }
}
