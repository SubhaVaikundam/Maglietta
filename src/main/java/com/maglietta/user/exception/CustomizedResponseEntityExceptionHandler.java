package com.maglietta.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.maglietta.user.dto.MessageResponse;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<MessageResponse> handleAllExceptions(Exception ex, WebRequest request) {
	  MessageResponse errorDetails = new MessageResponse(ex.getMessage());
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NoCustomerFoundException.class)
  public final ResponseEntity<MessageResponse> handleUserNotFoundException(NoCustomerFoundException ex, WebRequest request) {
	  MessageResponse errorDetails = new MessageResponse(ex.getMessage());
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

}
