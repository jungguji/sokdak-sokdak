package com.jgji.sokdak.global.model;

import com.jgji.sokdak.domain.member.domain.Email;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.member.domain.Password;

public class TempMember {

    public static Member getMember() {

        Email email = Email.builder()
                .email("jg.ji@gmail.com")
                .build();

        Password password = Password.builder()
                .password("qweqweqwe")
                .build();

        return Member.builder()
                .nickname("테스트")
                .email(email)
                .password(password)
                .build();
    }
}
