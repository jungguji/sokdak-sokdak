package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.domain.GroupRepository;
import com.jgji.sokdak.domain.group.exception.GroupNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupFindService {

    private final GroupRepository groupRepository;

    public Group findById(long id) {
        return this.groupRepository.findById(id)
                .orElseThrow(GroupNotFoundException::new);
    }

    public Group findByIdAndMemberId(long id, long memberId) {
        return this.groupRepository.findByIdAndMemberId(id, memberId)
                .orElseThrow(GroupNotFoundException::new);
    }
}
