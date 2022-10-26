package com.jgji.sokdak.domain.group.presentation.dto;

import com.jgji.sokdak.domain.group.domain.Group;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupCreateRequest {

    @NotEmpty(message = "이름을 설정해주세요.")
    @Size(max = 16, message = "이름은 16자 이내로 작성해주세요.")
    private String name;

    @Builder
    public GroupCreateRequest(String name) {
        this.name = name;
    }

    public Group toEntity(String logo) {
        return Group.builder()
                .name(name)
                .logo(logo)
                .build();
    }
}
