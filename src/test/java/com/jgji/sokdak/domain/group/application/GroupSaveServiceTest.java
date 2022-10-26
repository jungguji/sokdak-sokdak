package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.domain.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class GroupSaveServiceTest {


    private final GroupRepository groupRepository = mock(GroupRepository.class);

    private GroupSaveService groupSaveService;

    @BeforeEach
    void setUp() {
        groupSaveService = new GroupSaveService(groupRepository);
    }

    @Test
    void save() {
        //given
        Group given = Group.builder()
                .name("창동 프렌드")
                .logo("https://static-cdn.jtvnw.net/jtv_user_pictures/abcbd111-cb6c-4436-a04f-15bd8f515ea3-profile_image-300x300.png")
                .build();

        given(groupRepository.save(any())).willReturn(given);

        //when

        Group when = this.groupSaveService.save(given);

        //than
        assertThat(given.getName()).isEqualTo(when.getName());
        assertThat(given.getLogo()).isEqualTo(when.getLogo());
    }
}