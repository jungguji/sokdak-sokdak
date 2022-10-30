package com.jgji.sokdak.domain.group.exception;

import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;

public class InvalidCodeException extends BusinessException {

    public InvalidCodeException() {
        super(ErrorCode.INVALID_CODE);
    }
}
