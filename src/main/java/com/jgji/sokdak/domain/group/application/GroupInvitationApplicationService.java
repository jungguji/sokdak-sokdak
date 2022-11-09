package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupInvitationApplicationService {

    private final GroupInvitationSaveService groupInvitationSaveService;
    private final GroupInvitationFindService groupInvitationFindService;

    public String generateCode(Member member, long groupId, LocalDateTime now) {
        String code = generateCode(now);

        GroupInvitation groupInvitation = GroupInvitation.builder()
                .code(code)
                .memberId(member.getId())
                .groupId(groupId)
                .build();

        this.groupInvitationSaveService.save(groupInvitation);

        return groupInvitation.getCode();
    }

    private String generateCode(LocalDateTime now) {
        String invitationCode = GroupInvitation.generateCode();
        List<GroupInvitation> invitations = this.groupInvitationFindService.findByExpirationTimeGreaterThanEqualAndUsedFalse(now);

        while (invitations.contains(invitationCode)) {
            invitationCode = GroupInvitation.generateCode();
        }

        return invitationCode;
    }
}
