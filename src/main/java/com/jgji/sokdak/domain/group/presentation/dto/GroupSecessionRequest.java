package com.jgji.sokdak.domain.group.presentation.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupSecessionRequest {

    @NotNull(message = "탈퇴 할 모임을 선택해주세요.")
    private Long groupId;

    @NotEmpty(message = "문구를 정확히 입력해주세요.")
    private String confirmation;
}
