package com.example.Assignment.exception.controller;

import com.example.Assignment.exception.BookServiceException;
import com.example.Assignment.exception.apiError.ApiError;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @Override
    @ResponseBody
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException validException,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        BindingResult result = validException.getBindingResult();
        List<String> validationError = result.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ApiError apiError = new ApiError(BAD_REQUEST, "Validation Error");
        apiError.setValidationMessage(validationError);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(BookServiceException.class)
    protected ResponseEntity<Object> handleM3AdaptorUtilException(BookServiceException ex) {
        ApiError apiError;
        if (ex.getHttpStatus() != null) apiError = new ApiError(ex.getHttpStatus());
        else apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        apiError.setSuccess(false);
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
