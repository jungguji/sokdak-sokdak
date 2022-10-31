package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.domain.GroupInvitationRepository;
import com.jgji.sokdak.domain.group.exception.InvalidCodeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class GroupInvitationFindService {

    private final GroupInvitationRepository groupInvitationRepository;

    public GroupInvitation findByCodeAndExpirationTimeGreaterThanEqualAndUsedFalse(String code, LocalDateTime now) {
        return this.groupInvitationRepository.findByCodeAndExpirationTimeGreaterThanEqualAndUsedFalse(code, now)
                .orElseThrow(InvalidCodeException::new);
    }

}
