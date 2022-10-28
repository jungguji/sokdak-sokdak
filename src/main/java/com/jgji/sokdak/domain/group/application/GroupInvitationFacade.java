package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GroupInvitationFacade {

    private final GroupInvitationSaveService groupInvitationSaveService;

    public void save(Member member, long groupId) {
        GroupInvitation groupInvitation = GroupInvitation.builder()
                .memberId(member.getId())
                .groupId(groupId)
                .build();

        this.groupInvitationSaveService.save(groupInvitation);
    }
}
