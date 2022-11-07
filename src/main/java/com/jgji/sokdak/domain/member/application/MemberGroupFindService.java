package com.jgji.sokdak.domain.member.application;

import com.jgji.sokdak.domain.member.domain.MemberGroup;
import com.jgji.sokdak.domain.member.domain.MemberGroupRepository;
import com.jgji.sokdak.domain.member.exception.UnjoinedGroupException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberGroupFindService {

    private final MemberGroupRepository memberGroupRepository;

    public MemberGroup findByMemberIdAndGroupId(long memberId, long groupId) {
        return this.memberGroupRepository.findByMemberIdAndGroupId(memberId, groupId)
                .orElseThrow(UnjoinedGroupException::new);
    }
}
