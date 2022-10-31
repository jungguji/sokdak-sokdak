package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.domain.GroupInvitationRepository;
import com.jgji.sokdak.domain.member.application.MemberGroupSaveService;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class GroupInvitationSaveService {

    private final GroupInvitationFindService groupInvitationFindService;
    private final GroupFindService groupFindService;
    private final MemberGroupSaveService memberGroupSaveService;

    private final GroupInvitationRepository groupInvitationRepository;

    public GroupInvitation save(GroupInvitation groupInvitation) {
        return this.groupInvitationRepository.save(groupInvitation);
    }

    public Group join(Member member, String code, LocalDateTime now) {
        GroupInvitation invitation = this.groupInvitationFindService.findByCodeAndExpirationTimeGreaterThanEqualAndUsedFalse(code, now);

        invitation.join(member);

        return connectGroup(member, invitation);
    }

    private Group connectGroup(Member member, GroupInvitation invitation) {
        Group group = this.groupFindService.findById(invitation.getGroupId());
        this.memberGroupSaveService.connectGroup(member.getId(), group.getId());

        return group;
    }
}
