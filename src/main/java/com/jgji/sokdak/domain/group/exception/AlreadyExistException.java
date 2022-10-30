package com.jgji.sokdak.domain.group.exception;

import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;

public class AlreadyExistException extends BusinessException {

    public AlreadyExistException() {
        super(ErrorCode.CODE_ALREADY_EXIST);
    }
}
