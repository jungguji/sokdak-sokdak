package com.jgji.sokdak.domain.group.application.validator;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.domain.GroupInvitationRepository;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class GroupInvitationValidator {

    private final GroupInvitationRepository groupInvitationRepository;

    public void createValid(Member member, long groupId) {


        // 1. 유저가 해당 모임으로 생성한 코드 중 아직 유효한 코드가 존재하는지
        // 1-1. 유효한 코드가 존재하면 이미 유효한 코드가 존재한다는 exception
        LocalDateTime now = LocalDateTime.now();
        isAlreadyExistCode(member, groupId, now);

        String invitationCode = GroupInvitation.generateCode();
        // 2. 생성한 코드가 중복인지
        //      (expiration_time이 지나지 않았고, use가 false인 코드)
        // 2-1. 중복된 코드가 있다면 새로운 코드 생성

        generateCode(now);


    }

    private boolean isAlreadyExistCode(Member member, long groupId, LocalDateTime now) {
        return this.groupInvitationRepository.findByMemberIdAndGroupIdAndExpirationTimeGreaterThanEqualAndUsedFalse(member.getId(), groupId, now).size() > 0;

    }

    private void generateCode(LocalDateTime now) {
        int size = this.groupInvitationRepository.findByExpirationTimeGreaterThanEqualAndUsedFalse(now).size();
        if (size > 0) {

        }
    }
}
