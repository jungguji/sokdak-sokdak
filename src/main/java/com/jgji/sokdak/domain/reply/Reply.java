package com.jgji.sokdak.domain.reply;

import com.jgji.sokdak.global.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reply")
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_type", nullable = false)
    private ReplyTargetType replyTargetType;

    @Column(name = "target_id", nullable = false)
    private long replyTargetId;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Builder
    public Reply(String comment, ReplyTargetType replyTargetType, long replyTargetId, long memberId) {
        this.comment = comment;
        this.replyTargetType = replyTargetType;
        this.replyTargetId = replyTargetId;
        this.memberId = memberId;
    }
}
