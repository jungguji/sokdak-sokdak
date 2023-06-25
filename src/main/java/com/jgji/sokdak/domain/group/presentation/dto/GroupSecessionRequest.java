package com.jgji.sokdak.domain.group.presentation.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupSecessionRequest {

    @NotNull(message = "탈퇴 할 모임을 선택해주세요.")
    private Long groupId;

    @NotEmpty(message = "문구를 정확히 입력해주세요.")
    private String confirmation;

    @Builder
    public GroupSecessionRequest(Long groupId, String confirmation) {
        this.groupId = groupId;
        this.confirmation = confirmation;
    }
}
