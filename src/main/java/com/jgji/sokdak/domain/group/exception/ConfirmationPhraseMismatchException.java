package com.jgji.sokdak.domain.group.exception;

import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;

public class ConfirmationPhraseMismatchException extends BusinessException {

    public ConfirmationPhraseMismatchException() {
        super(ErrorCode.CONFIRMATION_PHRASE_MISMATCH);
    }
}
