package com._axislabs.attendance_system.enums;

public enum RestApiResponseStatusCodes {

    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized");

    private final int code;
    private final String message;

    RestApiResponseStatusCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
