package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.exception.ConfirmationPhraseMismatchException;
import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import com.jgji.sokdak.domain.group.presentation.dto.GroupJoinResponse;
import com.jgji.sokdak.domain.group.presentation.dto.GroupSecessionRequest;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.global.util.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class GroupFacade {

    private final GroupSaveService groupSaveService;
    private final GroupInvitationSaveService groupInvitationSaveService;

    private final GroupFindService groupFindService;

    public long create(Member member, GroupCreateRequest request, MultipartFile multipartFile) {
        Group group = request.toEntity(multipartFile.getOriginalFilename());

        this.groupSaveService.save(member, group);

        return group.getId();
    }

    public GroupJoinResponse join(Member member, String code) {
        LocalDateTime now = LocalDateTime.now();
        GroupInvitation useInvitation = this.groupInvitationSaveService.use(member, code, now);

        Group joinGroup = this.groupSaveService.join(member.getId(), useInvitation.getGroupId());

        return GroupJoinResponse.builder()
                .groupId(joinGroup.getId())
                .groupName(joinGroup.getName())
                .build();
    }

    public String secession(Member member, GroupSecessionRequest request) {

        Group group = this.groupFindService.findById(request.getGroupId());

        confirmationCheck(request, group);

        this.groupSaveService.secession(member.getId(), group.getId());

        return group.getName();
    }

    private void confirmationCheck(GroupSecessionRequest request, Group group) {
        final String confirmation = MessageUtils.getMessage("group.secession", new String[]{group.getName()});

        if (!confirmation.equals(request.getConfirmation())) {
            throw new ConfirmationPhraseMismatchException();
        }
    }
}
