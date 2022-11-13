package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.domain.GroupRepository;
import com.jgji.sokdak.domain.member.application.MemberGroupFindService;
import com.jgji.sokdak.domain.member.application.MemberGroupSaveService;
import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.member.domain.MemberGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class GroupSaveService {

    private final MemberGroupSaveService memberGroupSaveService;

    private final GroupFindService groupFindService;
    private final MemberGroupFindService memberGroupFindService;

    private final GroupRepository groupRepository;


    public Group save(Member member, Group group) {
        this.groupRepository.save(group);
        this.memberGroupSaveService.connectGroup(member.getId(), group.getId());

        return group;
    }

    public Group join(long memberId, long groupId) {
        Group group = this.groupFindService.findById(groupId);
        this.memberGroupSaveService.connectGroup(memberId, group.getId());

        return group;
    }

    public Group secession(long memberId, long groupId) {
        MemberGroup memberGroup = this.memberGroupFindService.findByMemberIdAndGroupId(memberId, groupId);
        Group group = this.groupFindService.findById(memberGroup.getGroupId());
        this.memberGroupSaveService.disconnectGroup(memberId, group.getId());

        return group;
    }
}
