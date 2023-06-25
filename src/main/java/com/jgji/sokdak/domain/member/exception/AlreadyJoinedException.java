package com.jgji.sokdak.domain.member.exception;

import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;

public class AlreadyJoinedException extends BusinessException {

    public AlreadyJoinedException() {
        super(ErrorCode.ALREADY_JOINED);
    }
}
