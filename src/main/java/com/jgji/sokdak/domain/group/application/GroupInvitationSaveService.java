package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.domain.GroupInvitationRepository;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@RequiredArgsConstructor
@Service
public class GroupInvitationSaveService {

    private final GroupInvitationFindService groupInvitationFindService;

    private final GroupInvitationRepository groupInvitationRepository;

    public GroupInvitation save(GroupInvitation groupInvitation) {
        return this.groupInvitationRepository.save(groupInvitation);
    }

    public GroupInvitation use(Member member, String code, LocalDateTime now) {
        GroupInvitation invitation = this.groupInvitationFindService.findByCodeAndExpirationTimeGreaterThanEqualAndUsedFalse(code, now);
        invitation.use(member);

        return invitation;
    }
}
