package com.jgji.sokdak.domain.member.application;

import com.jgji.sokdak.domain.member.domain.Member;
import com.jgji.sokdak.domain.member.domain.MemberRepository;
import com.jgji.sokdak.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberFindService {

    private final MemberRepository memberRepository;

    public Member findById(long id) {
        return this.memberRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
    }
}
