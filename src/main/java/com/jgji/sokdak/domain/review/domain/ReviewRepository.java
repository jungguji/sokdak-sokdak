package com.jgji.sokdak.domain.review.domain;

import com.jgji.sokdak.domain.review.infrastructure.ReviewCustomRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {

    List<Review> findByMemberId(long memberId);
}
