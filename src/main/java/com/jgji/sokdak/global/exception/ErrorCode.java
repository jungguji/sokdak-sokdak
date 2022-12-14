package com.jgji.sokdak.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // Common
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "C001", "존재하지 않는 데이터 입니다."),

    // Group Invitation
    CODE_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "GI001", "유효한 초대 코드가 이미 존재합니다."),
    INVALID_CODE(HttpStatus.BAD_REQUEST, "GI002", "유효하지 않은 초대 코드 입니다."),

    // Group
    GROUP_NOT_FOUND(HttpStatus.BAD_REQUEST, "G001", "존재하지 않는 모임입니다."),
    CONFIRMATION_PHRASE_MISMATCH(HttpStatus.BAD_REQUEST, "G002", "탈퇴 확인 문구를 정확히 입력해주세요."),

    //Member
    UNJOINED_GROUP(HttpStatus.BAD_REQUEST, "M002", "가입되지 않은 모임입니다."),
    ALREADY_JOINED(HttpStatus.BAD_REQUEST, "M003", "이미 가입된 모임입니다."),

    //Place
    ALREADY_PLACE(HttpStatus.BAD_REQUEST, "P001", "이미 존재하는 장소입니다."),
    ABNORMAL_COORDINATES(HttpStatus.BAD_REQUEST, "P002", "비정상적인 좌표 입니다."),

    // review
    NO_IMAGE(HttpStatus.BAD_REQUEST, "R001", "리뷰 이미지가 없습니다."),
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
