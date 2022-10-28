package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.domain.GroupInvitationRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GroupInvitationSaveService {

    private final GroupInvitationRepository groupInvitationRepository;

    public GroupInvitation save(GroupInvitation groupInvitation) {
        return this.groupInvitationRepository.save(groupInvitation);
    }
}
