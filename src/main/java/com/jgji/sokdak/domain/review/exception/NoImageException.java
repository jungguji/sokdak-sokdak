package com.jgji.sokdak.domain.review.exception;

import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;

public class NoImageException extends BusinessException {

    public NoImageException() {
        super(ErrorCode.NO_IMAGE);
    }
}
