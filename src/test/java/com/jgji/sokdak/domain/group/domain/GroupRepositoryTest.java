package com.jgji.sokdak.domain.group.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GroupRepositoryTest {

    @Autowired
    private GroupRepository groupRepository;

    @DisplayName(value = "저장 테스트")
    @Test
    void save() {
        //given
        Group given = Group.builder()
                .name("창동 프렌드")
                .logo("https://static-cdn.jtvnw.net/jtv_user_pictures/abcbd111-cb6c-4436-a04f-15bd8f515ea3-profile_image-300x300.png")
                .build();
        //when
        Group when = this.groupRepository.save(given);

        //then
        assertThat(given.getName()).isEqualTo(when.getName());
        assertThat(given.getLogo()).isEqualTo(when.getLogo());
    }
}