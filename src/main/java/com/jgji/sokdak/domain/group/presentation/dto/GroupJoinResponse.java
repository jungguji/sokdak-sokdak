package com.jgji.sokdak.domain.group.presentation.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupJoinResponse {

    private long groupId;
    private String groupName;

    @Builder
    public GroupJoinResponse(long groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }
}
