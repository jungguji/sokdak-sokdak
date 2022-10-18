package com.jgji.sokdak.domain.group.domain;

import com.jgji.sokdak.global.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "group_invitation")
@Entity
public class GroupInvitation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "used", nullable = false, columnDefinition = "bit(1) default false")
    private boolean used;

    @Column(name = "expiration_time", nullable = false)
    private LocalDateTime expirationTime;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "group_id", nullable = false)
    private long groupId;

    @Column(name = "invited_member_id", nullable = false)
    private long invitedMemberId;

    @Builder
    public GroupInvitation(String code, boolean used, long memberId, long groupId, long invitedMemberId) {
        this.code = code;
        this.used = used;
        this.memberId = memberId;
        this.groupId = groupId;
        this.invitedMemberId = invitedMemberId;
        setExpirationTime();
    }

    private void setExpirationTime() {
        LocalDateTime createdDateTime = super.getCreatedDateTime();
        this.expirationTime = createdDateTime.plusDays(1);
    }
}
