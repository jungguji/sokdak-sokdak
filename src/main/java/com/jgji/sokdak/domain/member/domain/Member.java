package com.jgji.sokdak.domain.member.domain;

import com.jgji.sokdak.global.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Embedded
    private Email email;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Embedded
    private Password password;

    @Column(name = "profile_image")
    private String profileImage;

    @Builder
    public Member(Email email, String nickname, Password password, String profileImage) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.profileImage = profileImage;
    }
}
