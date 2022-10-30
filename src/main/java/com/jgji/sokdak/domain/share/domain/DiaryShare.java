package com.jgji.sokdak.domain.share.domain;

import com.jgji.sokdak.domain.diary.domain.Diary;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("DIARY")
@Table(name = "diary_share")
@Entity
public class DiaryShare extends Share {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id", nullable = false)
    private Diary diary;

    @Builder
    public DiaryShare(long groupId, Diary diary) {
        super(groupId);
        this.diary = diary;
    }
}
