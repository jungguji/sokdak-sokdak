package com.jgji.sokdak.domain.calendar.domain;

import com.jgji.sokdak.domain.share.domain.CalendarShare;
import com.jgji.sokdak.global.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "calendar")
@Entity
public class Calendar extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "target_date_time", nullable = false)
    private LocalDateTime targetDateTime;

    @Column(name = "importance")
    @Enumerated(EnumType.STRING)
    private Importance importance;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "place_id")
    private long placeId;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    @Column(name = "share_id")
    private List<CalendarShare> calendarShares = new ArrayList<>();

    @Builder
    public Calendar(String title, String content, LocalDateTime targetDateTime, Importance importance, long memberId, long placeId, List<CalendarShare> calendarShares) {
        this.title = title;
        this.content = content;
        this.targetDateTime = targetDateTime;
        this.importance = importance;
        this.memberId = memberId;
        this.placeId = placeId;
        this.calendarShares = calendarShares;
    }
}
