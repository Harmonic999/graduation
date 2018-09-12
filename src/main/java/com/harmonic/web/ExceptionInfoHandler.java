package com.harmonic.web;

import com.harmonic.util.ValidationUtil;
import com.harmonic.util.exception.ErrorInfo;
import com.harmonic.util.exception.FieldEmptyException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE + 5)
public class ExceptionInfoHandler {

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)  // 422
    @ExceptionHandler(FieldEmptyException.class)
    public ErrorInfo illegalRequestDataError(Exception e) {
        return logAndGetErrorInfo(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorInfo handleError(Exception e) {
        return logAndGetErrorInfo(e);
    }

    private static ErrorInfo logAndGetErrorInfo(Exception e) {
        Throwable rootCause = ValidationUtil.getRootCause(e);
        return new ErrorInfo(ValidationUtil.getMessage(rootCause));
    }
}