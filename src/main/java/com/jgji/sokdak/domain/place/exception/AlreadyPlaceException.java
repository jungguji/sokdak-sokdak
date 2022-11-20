package com.jgji.sokdak.domain.place.exception;

import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;

public class AlreadyPlaceException extends BusinessException {

    public AlreadyPlaceException() {
        super(ErrorCode.ALREADY_PLACE);
    }
}
