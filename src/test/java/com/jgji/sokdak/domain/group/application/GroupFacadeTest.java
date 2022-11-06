package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.member.domain.MemberGroup;
import com.jgji.sokdak.domain.member.domain.MemberGroupRepository;
import com.jgji.sokdak.domain.member.domain.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class GroupFacadeTest {

    @Autowired
    private GroupFacade groupFacade;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberGroupRepository memberGroupRepository;

    @DisplayName(value = "모임 생성 테스트")
    @Test
    void create() throws IOException {
        //given
        Member member = this.memberRepository.findById(1L).get();

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

        assertThat(1).isEqualTo(all.size());

    }
}