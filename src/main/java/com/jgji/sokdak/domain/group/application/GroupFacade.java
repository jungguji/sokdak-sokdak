package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import com.jgji.sokdak.domain.member.application.MemberGroupSaveService;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.member.domain.MemberGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Component
public class GroupFacade {

    private final GroupSaveService groupSaveService;
    private final MemberGroupSaveService memberGroupSaveService;

    public long create(Member member, GroupCreateRequest request, MultipartFile multipartFile) {
        Group group = request.toEntity(multipartFile.getOriginalFilename());

        this.groupSaveService.save(group);
        connectGroup(member.getId(), group.getId());

        return group.getId();
    }

    private void connectGroup(long memberId, long groupId) {
        MemberGroup memberGroup = getMemberGroup(memberId, groupId);

        this.memberGroupSaveService.save(memberGroup);
    }

    private MemberGroup getMemberGroup(long memberId, long groupId) {
        return MemberGroup.builder()
                .memberId(memberId)
                .groupId(groupId)
                .build();
    }
}
