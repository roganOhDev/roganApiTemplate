package com.example.api.exception;

public class UnknownException extends ApiException {
    private final static String exceptionCode = ExceptionCode.Api.UNKNOWN_EXCEPTION;

    UnknownException() {
        super(exceptionCode);
    }

    UnknownException(String message) {
        super(exceptionCode + "  , message");
    }
}
