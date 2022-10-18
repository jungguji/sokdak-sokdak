package com.jgji.sokdak.domain.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Email {

    @jakarta.validation.constraints.Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Builder
    public Email(@jakarta.validation.constraints.Email String email) {
        this.email = email;
    }
}
