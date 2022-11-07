package com.jgji.sokdak.domain.member.exception;

import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;

public class UnjoinedGroupException extends BusinessException {

    public UnjoinedGroupException() {
        super(ErrorCode.UNJOINED_GROUP);
    }
}
