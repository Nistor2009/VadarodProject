package com.example.VadarodProject.exception;

import com.example.VadarodProject.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity<ErrorResponse> fieldIsEmpty(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(500);
        errorResponse.setMessage(e.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }

    @ResponseBody
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> fieldIsEmpty(MethodArgumentNotValidException e){
        List<String> messages = Collections.emptyList();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        messages = errors.stream().map(ObjectError::getDefaultMessage).toList();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(401);
        errorResponse.setMessages(messages);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
