package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class GroupFacadeTest {

    @Autowired
    private GroupFacade groupFacade;


    @Test
    void create() throws IOException {
        //given

        MockMultipartFile mockMultipartFile = new MockMultipartFile("test", "originName", "txt", new FileInputStream("C:\\Users\\eleme\\Documents\\b22fece4-ab44-4449-9aed-cafc95681ee9.txt"));

        GroupCreateRequest given = GroupCreateRequest.builder()
                .name("창동 프랜드")
                .build();

        //when
        long id = this.groupFacade.create(given, mockMultipartFile);
        //then

        assertThat(1).isEqualTo(id);
    }
}