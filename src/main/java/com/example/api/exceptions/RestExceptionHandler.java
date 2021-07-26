package com.example.api.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {PetNotFoundException.class})
    protected ResponseEntity<Object> handlePetNotFoundException(RuntimeException e, WebRequest request){
        ExceptionBody body=ExceptionBody
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.NO_CONTENT.value())
                .path(request.getDescription(true))
                .timestamp(new Date().toString())
                .build();
        return handleExceptionInternal(e,body,new HttpHeaders(),HttpStatus.NO_CONTENT,request);
    }

    @ExceptionHandler(value = {OwnerNotFoundException.class})
    protected ResponseEntity<Object> handleOwnerNotFoundException(RuntimeException e, WebRequest request){
        ExceptionBody body=ExceptionBody
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.NO_CONTENT.value())
                .path(request.getDescription(true))
                .timestamp(new Date().toString())
                .build();
        return handleExceptionInternal(e,body,new HttpHeaders(),HttpStatus.NO_CONTENT,request);
    }

    @ExceptionHandler(value = {VetNotFoundException.class})
    protected ResponseEntity<Object> handleVetNotFoundException(RuntimeException e, WebRequest request){
        ExceptionBody body=ExceptionBody
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.NO_CONTENT.value())
                .path(request.getDescription(true))
                .timestamp(new Date().toString())
                .build();
        return handleExceptionInternal(e,body,new HttpHeaders(),HttpStatus.NO_CONTENT,request);
    }

    @ExceptionHandler(value = {ScheduleNotFoundException.class})
    protected ResponseEntity<Object> handleScheduleNotFoundException(RuntimeException e, WebRequest request){
        ExceptionBody body=ExceptionBody
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.NO_CONTENT.value())
                .path(request.getDescription(true))
                .timestamp(new Date().toString())
                .build();
        return handleExceptionInternal(e,body,new HttpHeaders(),HttpStatus.NO_CONTENT,request);
    }

    @ExceptionHandler(value = {AppointmentNotFoundException.class})
    protected ResponseEntity<Object> handleAppointmentNotFoundException(RuntimeException e, WebRequest request){
        ExceptionBody body=ExceptionBody
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.NO_CONTENT.value())
                .path(request.getDescription(true))
                .timestamp(new Date().toString())
                .build();
        return handleExceptionInternal(e,body,new HttpHeaders(),HttpStatus.NO_CONTENT,request);
    }
}
