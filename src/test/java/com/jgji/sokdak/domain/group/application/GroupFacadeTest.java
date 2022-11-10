package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import com.jgji.sokdak.domain.group.presentation.dto.GroupJoinResponse;
import com.jgji.sokdak.domain.group.presentation.dto.GroupSecessionRequest;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.member.domain.MemberGroup;
import com.jgji.sokdak.domain.member.domain.MemberGroupRepository;
import com.jgji.sokdak.domain.member.domain.MemberRepository;
import com.jgji.sokdak.domain.member.exception.AlreadyJoinedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class GroupFacadeTest {

    @Autowired
    private GroupFacade groupFacade;

    @Autowired
    private GroupInvitationApplicationService groupInvitationApplicationService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberGroupRepository memberGroupRepository;

    private Member member;
    @BeforeEach
    void setUp() {
        this.member = this.memberRepository.findById(1L).get();
    }

    @DisplayName(value = "모임 생성 테스트")
    @Test
    void create() throws IOException {
        //given
        MockMultipartFile mockMultipartFile = new MockMultipartFile("test", "originName", "txt", new FileInputStream("C:\\Users\\eleme\\Documents\\b22fece4-ab44-4449-9aed-cafc95681ee9.txt"));

        String name = "창동 프랜드";
        GroupCreateRequest given = GroupCreateRequest.builder()
                .name(name)
                .build();

        //when
        Group when = this.groupFacade.create(member, given, mockMultipartFile);

        //then
        assertThat(name).isEqualTo(when.getName());

        List<MemberGroup> all = this.memberGroupRepository.findAll();

        assertThat(all.size()).isEqualTo(1);
        assertThat(all.get(0).getGroupId()).isEqualTo(when.getId());
        assertThat(all.get(0).getMemberId()).isEqualTo(member.getId());
    }

    @DisplayName(value = "모임 입장 테스트")
    @Test
    void join() {
        //given
        long groupId = 1L;
        LocalDateTime now = LocalDateTime.now();

        Member guest = this.memberRepository.findById(2L).get();

        String code = this.groupInvitationApplicationService.generateCode(guest, groupId, now);

        //when
        GroupJoinResponse when = this.groupFacade.join(guest, code);

        //then
        assertThat(when.getGroupId()).isEqualTo(groupId);
        assertThat(when.getGroupName()).isEqualTo("기본 생성 모임 1호");
    }

    @DisplayName(value = "이미 입장해있는 모임에 다시 조인")
    @Test
    void joinException() {
        //given
        long groupId = 1L;
        LocalDateTime now = LocalDateTime.now();

        MemberGroup memberGroup = MemberGroup.builder()
                .groupId(groupId)
                .memberId(member.getId())
                .build();

        memberGroupRepository.save(memberGroup);

        String code = this.groupInvitationApplicationService.generateCode(member, groupId, now);

        //when
        assertThrows(AlreadyJoinedException.class, () -> this.groupFacade.join(member, code));
    }

    @DisplayName(value = "모임 탈퇴")
    @Test
    void secession() {
        //given
        Member member = this.memberRepository.findById(3L).get();
        String groupName = "기본 생성 모임 1호";

        GroupSecessionRequest request = GroupSecessionRequest.builder()
                .groupId(1L)
                .confirmation(groupName + " 탈퇴하기")
                .build();

        //when
        String secessionGroupName = this.groupFacade.secession(member, request);

        //then
        assertThat(secessionGroupName).isEqualTo(groupName);

    }
}