package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.exception.AlreadyExistException;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class GroupInvitationFacade {

    private final GroupInvitationApplicationService groupInvitationApplicationService;
    private final GroupInvitationFindService groupInvitationFindService;

    public String save(Member member, long groupId) {
        LocalDateTime now = LocalDateTime.now();

        alreadyExistCode(member, groupId, now);

        return this.groupInvitationApplicationService.generateCode(member, groupId, now);
    }

    private void alreadyExistCode(Member member, long groupId, LocalDateTime now) {
        boolean alreadyExistCode = this.groupInvitationFindService.findValidCode(member, groupId, now).size() > 0;

        if (alreadyExistCode) {
            throw new AlreadyExistException();
        }
    }
}
