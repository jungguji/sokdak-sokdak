package com.jgji.sokdak.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // Group Invitation
    CODE_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "GI001", "유효한 초대 코드가 이미 존재합니다."),
    INVALID_CODE(HttpStatus.BAD_REQUEST, "GI002", "유효하지 않은 초대 코드 입니다."),

    // Group
    GROUP_NOT_FOUND(HttpStatus.BAD_REQUEST, "G001", "존재하지 않는 모임입니다."),
    CONFIRMATION_PHRASE_MISMATCH(HttpStatus.BAD_REQUEST, "G002", "탈퇴 확인 문구를 정확히 입력해주세요."),

    //Member
    UNJOINED_GROUP(HttpStatus.BAD_REQUEST, "M002", "가입되지 않은 모임입니다.")

    ;

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
