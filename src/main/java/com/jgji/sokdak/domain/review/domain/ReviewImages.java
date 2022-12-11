package com.jgji.sokdak.domain.review.domain;

import com.jgji.sokdak.domain.review.exception.NoImageException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ReviewImages {

    public static final int THUMBNAIL_INDEX = 0;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewImage> reviewImages = new ArrayList<>();

    public ReviewImages(List<ReviewImage> reviewImages) {
        this.reviewImages = reviewImages;
    }

    public List<String> getImages() {
        return this.reviewImages
            .stream()
            .map(ReviewImage::getImage)
            .collect(Collectors.toList());
    }

    public String getThumbnail() {
        if (ObjectUtils.isEmpty(this.reviewImages)) {
            throw new NoImageException();
        }

        return this.reviewImages.get(THUMBNAIL_INDEX).getImage();
    }
}
