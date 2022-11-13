package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.domain.GroupInvitationRepository;
import com.jgji.sokdak.domain.group.exception.AlreadyExistException;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.member.domain.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@SpringBootTest
class GroupInvitationApplicationServiceTest {

    @Autowired
    private GroupInvitationApplicationService groupInvitationApplicationService;

    @Autowired
    private MemberRepository memberRepository;

        @Autowired
    private GroupInvitationRepository groupInvitationRepository;

    private Member member;
    @BeforeEach
    void setUp() {
        this.member = this.memberRepository.findById(1L).get();
    }

    @DisplayName(value = "초대코드 생성")
    @Test
    void generateCode() {
        //given
        LocalDateTime now = LocalDateTime.now();
        //when
        String generateCode = this.groupInvitationApplicationService.generateCode(member, 1L, now);
        //then

        assertThat(is(generateCode.length() > 0));
        log.info("code ={}", generateCode);
    }

    @DisplayName(value = "이미 유효한 초대코드가 존재함")
    @Test
    void fail() {
        //given
        GroupInvitation groupInvitation = GroupInvitation.builder()
                .code("QWERASDF")
                .memberId(member.getId())
                .groupId(1L)
                .build();

        this.groupInvitationRepository.save(groupInvitation);

        LocalDateTime now = LocalDateTime.now();

        //when
        assertThrows(AlreadyExistException.class, () ->
                this.groupInvitationApplicationService.generateCode(member, 1L, now));
    }

    @AfterEach
    void tearDown() {
        this.groupInvitationRepository.deleteAll();
    }
}