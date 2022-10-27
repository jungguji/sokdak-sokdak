package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import com.jgji.sokdak.domain.member.domain.*;
import com.jgji.sokdak.global.model.TempMember;
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
        Member member = TempMember.getMember();

        this.memberRepository.save(member);

        MockMultipartFile mockMultipartFile = new MockMultipartFile("test", "originName", "txt", new FileInputStream("C:\\Users\\eleme\\Documents\\b22fece4-ab44-4449-9aed-cafc95681ee9.txt"));

        GroupCreateRequest given = GroupCreateRequest.builder()
                .name("창동 프랜드")
                .build();

        //when
        long id = this.groupFacade.create(member, given, mockMultipartFile);

        //then
        assertThat(1).isEqualTo(id);

        List<MemberGroup> all = this.memberGroupRepository.findAll();

        assertThat(1).isEqualTo(all.size());

    }
}