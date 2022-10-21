package com.jgji.sokdak.domain.calendar.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "calendar_share")
@Entity
public class CalendarShare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "calendar_id", nullable = false)
    private Calendar calendar;

    @Column(name = "group_id", nullable = false)
    private long groupId;

    @Builder
    public CalendarShare(Calendar calendar, long groupId) {
        this.calendar = calendar;
        this.groupId = groupId;
    }
}
