package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GroupInvitationFacade {

    private final GroupInvitationSaveService groupInvitationSaveService;
    private final GroupInvitationApplicationService groupInvitationApplicationService;

    public String save(Member member, long groupId) {
        String code = this.groupInvitationApplicationService.generateCode(member, groupId);

        GroupInvitation groupInvitation = GroupInvitation.builder()
                .code(code)
                .memberId(member.getId())
                .groupId(groupId)
                .build();

        this.groupInvitationSaveService.save(groupInvitation);
        return code;
    }
}
