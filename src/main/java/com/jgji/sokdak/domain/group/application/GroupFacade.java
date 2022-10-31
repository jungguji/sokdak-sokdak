package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import com.jgji.sokdak.domain.group.presentation.dto.GroupJoinResponse;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class GroupFacade {

    private final GroupSaveService groupSaveService;
    private final GroupInvitationSaveService groupInvitationSaveService;

    public long create(Member member, GroupCreateRequest request, MultipartFile multipartFile) {
        Group group = request.toEntity(multipartFile.getOriginalFilename());

        this.groupSaveService.save(member, group);

        return group.getId();
    }


    public GroupJoinResponse join(Member member, String code) {
        LocalDateTime now = LocalDateTime.now();
        Group joinGroup = this.groupInvitationSaveService.join(member, code, now);

        return GroupJoinResponse.builder()
                .groupId(joinGroup.getId())
                .groupName(joinGroup.getName())
                .build();
    }
}
