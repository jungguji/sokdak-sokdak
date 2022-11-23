package com.jgji.sokdak.domain.group.presentation;

import com.jgji.sokdak.domain.group.application.GroupFacade;
import com.jgji.sokdak.domain.group.presentation.dto.GroupCreateRequest;
import com.jgji.sokdak.domain.group.presentation.dto.GroupSecessionRequest;
import com.jgji.sokdak.global.model.TempMember;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping(path = "/group")
@RestController
public class GroupController {

    private final GroupFacade groupFacade;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public Long create(@RequestPart(name = "group") @Valid GroupCreateRequest groupCreateRequest
            , @RequestPart(name = "logoFile") MultipartFile logoImage) {

        return this.groupFacade.create(TempMember.getGroupLeader(), groupCreateRequest, logoImage).getId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void join(@RequestBody @Valid @NotEmpty String code) {
        this.groupFacade.join(TempMember.getGroupMember(), code);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String secession(@RequestBody @Valid GroupSecessionRequest request) {
        return this.groupFacade.secession(TempMember.getGroupMember(), request);
    }
}
