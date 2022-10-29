package com.jgji.sokdak.domain.group.domain;

import com.jgji.sokdak.global.model.BaseEntity;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
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

    @Column(name = "used", nullable = false)
    private boolean used;

    @Column(name = "expiration_time", nullable = false)
    private LocalDateTime expirationTime;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "group_id", nullable = false)
    private long groupId;

    @Column(name = "invited_member_id")
    private Long invitedMemberId;

    @Builder
    public GroupInvitation(String code, long memberId, long groupId) {
        this.code = code;
        this.used = false;
        this.memberId = memberId;
        this.groupId = groupId;
        this.invitedMemberId = null;
        setExpirationTime();
    }

    private void setExpirationTime() {
        LocalDateTime createdDateTime = LocalDateTime.now();
        this.expirationTime = createdDateTime.plusDays(1);
    }

    public void use() {
        this.used = true;
    }

    public static String generateCode() {
        return RandomStringUtils.randomAlphanumeric(8);
    }
}
