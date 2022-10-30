package com.jgji.sokdak.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // Group Invitation
    CODE_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "GI001", "유효한 초대 코드가 이미 존재합니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
