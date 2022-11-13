package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.domain.GroupInvitationRepository;
import com.jgji.sokdak.domain.group.exception.InvalidCodeException;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupInvitationFindService {

    private final GroupInvitationRepository groupInvitationRepository;

    public GroupInvitation findByCodeAndExpirationTimeGreaterThanEqualAndUsedFalse(String code, LocalDateTime now) {
        return this.groupInvitationRepository.findByCodeAndExpirationTimeGreaterThanEqualAndUsedFalse(code, now)
                .orElseThrow(InvalidCodeException::new);
    }

    public List<GroupInvitation> findValidCode(Member member, long groupId, LocalDateTime now) {
        return this.groupInvitationRepository.findByMemberIdAndGroupIdAndExpirationTimeGreaterThanEqualAndUsedFalse(member.getId(), groupId, now);
    }

    public List<GroupInvitation> findByExpirationTimeGreaterThanEqualAndUsedFalse(LocalDateTime now) {
        return this.groupInvitationRepository.findByExpirationTimeGreaterThanEqualAndUsedFalse(now);
    }
}
