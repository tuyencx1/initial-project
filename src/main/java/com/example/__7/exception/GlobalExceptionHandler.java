package com.example.__7.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.__7.dto.resquest.ResponsiData;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ResponsiData> runtimeExceptionHandler(RuntimeException exception) {
        ResponsiData responsiData = new ResponsiData();
        responsiData.setCode("1001");
        responsiData.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(responsiData);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ResponsiData> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        ResponsiData responsiData = new ResponsiData();
        responsiData.setCode("1002");
        responsiData.setMessage(exception.getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(responsiData);
    }
}
