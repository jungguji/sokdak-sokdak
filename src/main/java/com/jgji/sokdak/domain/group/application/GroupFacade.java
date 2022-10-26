package com.jgji.sokdak.domain.group.application;

import com.jgji.sokdak.domain.group.domain.Group;
import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Component
public class GroupFacade {

    private final GroupSaveService groupSaveService;

    public long create(GroupCreateRequest request, MultipartFile multipartFile) {
        Group group = request.toEntity(multipartFile.getOriginalFilename());

        this.groupSaveService.save(group);
        return group.getId();
    }
}
