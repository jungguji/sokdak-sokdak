package com.jgji.sokdak.domain.member.application;

import com.jgji.sokdak.domain.member.domain.MemberGroup;
import com.jgji.sokdak.domain.member.domain.MemberGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberGroupSaveService {

    private final MemberGroupFindService memberGroupFindService;

    private final MemberGroupRepository memberGroupRepository;

    public MemberGroup save(MemberGroup memberGroup) {
        return this.memberGroupRepository.save(memberGroup);
    }

    public void delete(MemberGroup memberGroup) {
        this.memberGroupRepository.delete(memberGroup);
    }

    public MemberGroup connectGroup(long memberId, long groupId) {
        MemberGroup memberGroup = this.getMemberGroup(memberId, groupId);
        return this.save(memberGroup);
    }

    private MemberGroup getMemberGroup(long memberId, long groupId) {
        return MemberGroup.builder()
                .memberId(memberId)
                .groupId(groupId)
                .build();
    }

    public void disconnectGroup(long memberId, long groupId) {
        MemberGroup memberGroup = this.memberGroupFindService.findByMemberIdAndGroupId(memberId, groupId);
        this.delete(memberGroup);
    }
}
