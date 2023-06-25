package com.jgji.sokdak.domain.diary.domain;

import com.jgji.sokdak.domain.share.domain.DiaryShare;
import com.jgji.sokdak.global.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "diary")
@Entity
public class Diary extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "visible", nullable = false)
    @Enumerated(EnumType.STRING)
    private Visible visible;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "place_id")
    private long placeId;

    @Column(name = "calendar_id")
    private long calendarId;

    @OneToMany(mappedBy = "diary", cascade = CascadeType.ALL)
    private List<DiaryImage> diaryImages = new ArrayList<>();

    @OneToMany(mappedBy = "diary", cascade = CascadeType.ALL)
    @Column(name = "share_id")
    private List<DiaryShare> diaryShares = new ArrayList<>();

    @Builder
    public Diary(String content, Visible visible, long memberId, long placeId, long calendarId, List<DiaryImage> diaryImages, List<DiaryShare> diaryShares) {
        this.content = content;
        this.visible = visible;
        this.memberId = memberId;
        this.placeId = placeId;
        this.calendarId = calendarId;
        this.diaryImages = diaryImages;
        this.diaryShares = diaryShares;
    }
}
