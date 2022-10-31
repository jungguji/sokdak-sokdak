package com.jgji.sokdak.domain.group.exception;

import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;

public class GroupNotFoundException extends BusinessException {

    public GroupNotFoundException() {
        super(ErrorCode.GROUP_NOT_FOUND);
    }
}
