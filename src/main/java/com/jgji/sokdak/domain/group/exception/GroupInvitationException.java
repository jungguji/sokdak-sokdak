package com.jgji.sokdak.domain.group.exception;

import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;

public class GroupInvitationException extends BusinessException {

    public GroupInvitationException() {
        super(ErrorCode.CODE_ALREADY_EXIST);
    }
}
