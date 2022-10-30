package com.jgji.sokdak.domain.member.domain;

import com.jgji.sokdak.global.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_group")
@Entity
public class MemberGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "group_id", nullable = false)
    private long groupId;

    @Builder
    public MemberGroup(long memberId, long groupId) {
        this.memberId = memberId;
        this.groupId = groupId;
    }
}
