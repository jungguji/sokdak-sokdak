package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.domain.GroupInvitationRepository;
import com.jgji.sokdak.domain.group.exception.AlreadyExistException;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupInvitationApplicationService {

    private final GroupInvitationRepository groupInvitationRepository;

    public String generateCode(Member member, long groupId) {
        LocalDateTime now = LocalDateTime.now();

        alreadyExistCode(member, groupId, now);

        return generateCode(now);
    }

    private void alreadyExistCode(Member member, long groupId, LocalDateTime now) {
        boolean alreadyExistCode = this.groupInvitationRepository.findByMemberIdAndGroupIdAndExpirationTimeGreaterThanEqualAndUsedFalse(member.getId(), groupId, now).size() > 0;

        if (alreadyExistCode) {
            throw new AlreadyExistException();
        }
    }

    private String generateCode(LocalDateTime now) {
        String invitationCode = GroupInvitation.generateCode();
        List<GroupInvitation> invitations = this.groupInvitationRepository.findByExpirationTimeGreaterThanEqualAndUsedFalse(now);

        while (invitations.contains(invitationCode)) {
            invitationCode = GroupInvitation.generateCode();
        }

        return invitationCode;
    }
}
