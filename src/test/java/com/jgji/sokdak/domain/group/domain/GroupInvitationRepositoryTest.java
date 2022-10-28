package com.jgji.sokdak.domain.group.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DataJpaTest
class GroupInvitationRepositoryTest {

    @Autowired
    private GroupInvitationRepository groupInvitationRepository;

    @Test
    void findByMemberIdAndGroupIdAndExpirationTimeGreaterThanEqualAndUseFalse() {
        List<GroupInvitation> givens = IntStream.range(1, 11)
                .mapToObj(i -> GroupInvitation.builder()
                        .groupId(i)
                        .memberId(1)
                        .code("AAAAAAA" + i)
                        .build())
                .collect(Collectors.toList());

        this.groupInvitationRepository.saveAll(givens);

        List<GroupInvitation> list = this.groupInvitationRepository.findByMemberIdAndGroupIdAndExpirationTimeGreaterThanEqualAndUsedFalse(1, 1, LocalDateTime.now());

        for (GroupInvitation groupInvitation : list) {
            System.out.println("groupInvitation.toString() = " + groupInvitation.toString());
        }
    }
}