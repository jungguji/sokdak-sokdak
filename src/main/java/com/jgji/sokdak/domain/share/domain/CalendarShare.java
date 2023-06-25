package com.jgji.sokdak.domain.share.domain;

import com.jgji.sokdak.domain.calendar.domain.Calendar;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("CALENDAR")
@Table(name = "calendar_share")
@Entity
public class CalendarShare extends Share {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id", nullable = false)
    private Calendar calendar;

    @Builder
    public CalendarShare(long groupId, Calendar calendar) {
        super(groupId);
        this.calendar = calendar;
    }
}
