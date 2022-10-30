package com.jgji.sokdak.domain.group.application.validator;

import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.domain.GroupInvitationRepository;
import com.jgji.sokdak.domain.group.exception.InvalidCodeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class GroupInvitationValidator {

    private final GroupInvitationRepository groupInvitationRepository;

    public void validate(String code) {

    }
}
