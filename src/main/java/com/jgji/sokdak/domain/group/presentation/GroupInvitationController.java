package com.jgji.sokdak.domain.group.presentation;

import com.jgji.sokdak.domain.group.application.GroupInvitationFacade;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.global.model.TempMember;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/invitation")
@RestController
public class GroupInvitationController {

    private final GroupInvitationFacade groupInvitationFacade;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String generateCode(@RequestBody @Valid @NotNull Long groupId) {
        Member member = TempMember.getGroupLeader();
        return this.groupInvitationFacade.save(member, groupId);
    }
}
