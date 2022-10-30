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

    private final MemberGroupRepository memberGroupRepository;

    public MemberGroup save(MemberGroup memberGroup) {
        return this.memberGroupRepository.save(memberGroup);
    }
}
