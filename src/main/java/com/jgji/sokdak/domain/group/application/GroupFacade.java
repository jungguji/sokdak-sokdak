package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.domain.GroupInvitation;
import com.jgji.sokdak.domain.group.exception.InvalidCodeException;
import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import com.jgji.sokdak.domain.member.application.MemberGroupSaveService;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.member.domain.MemberGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Component
public class GroupFacade {

    private final GroupSaveService groupSaveService;
    private final MemberGroupSaveService memberGroupSaveService;
    private final GroupInvitationFindService groupInvitationFindService;

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

    public void join(Member member, String code) {
        GroupInvitation invitation = this.groupInvitationFindService.findByCodeAndExpirationTimeGreaterThanEqualAndUsedFalse(code);

        if (ObjectUtils.isEmpty(invitation)) {
            throw new InvalidCodeException();
        }

        invitation.join(member);
        MemberGroup.builder()
                .memberId(member.getId())
                .groupId(invitation.getGroupId())
                .build();
    }
}
