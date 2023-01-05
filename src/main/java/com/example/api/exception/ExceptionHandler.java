package com.example.api.exception;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> exception(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(new ExceptionDto(e));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDto> exception(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(new ExceptionDto(e));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RException.class)
    public ResponseEntity<ExceptionDto> exception(RException e) {
        return ResponseEntity.badRequest().body(new ExceptionDto(e));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ExceptionDto> exception(WebExchangeBindException e) {
        return ResponseEntity.badRequest().body(new ExceptionDto(e));
    }
}
