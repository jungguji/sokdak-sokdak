package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.domain.GroupRepository;
import com.jgji.sokdak.domain.member.application.MemberGroupSaveService;
import com.jgji.sokdak.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class GroupSaveService {

    private final GroupRepository groupRepository;
    private final MemberGroupSaveService memberGroupSaveService;

    public Group save(Member member, Group group) {
        this.groupRepository.save(group);
        this.memberGroupSaveService.connectGroup(member.getId(), group.getId());

        return group;
    }
}
