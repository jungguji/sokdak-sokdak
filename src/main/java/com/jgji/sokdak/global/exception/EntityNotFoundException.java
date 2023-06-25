package com.jgji.sokdak.global.exception;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException() {
        super(ErrorCode.ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException(String target) {
        super(target + "(이)가 존재하지 않습니다.", ErrorCode.ENTITY_NOT_FOUND);
    }
}
