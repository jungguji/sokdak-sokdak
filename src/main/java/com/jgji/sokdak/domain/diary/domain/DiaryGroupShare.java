package com.jgji.sokdak.domain.diary.domain;

import com.jgji.sokdak.global.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "diary_group_share")
@Entity
public class DiaryGroupShare extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "diary_id", nullable = false)
    private Diary diary;

    @Column(name = "group_id", nullable = false)
    private long groupId;
}
