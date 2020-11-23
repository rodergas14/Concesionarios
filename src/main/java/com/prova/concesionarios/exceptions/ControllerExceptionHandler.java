package com.prova.concesionarios.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler {
	
	  @ExceptionHandler(value = {DeleteCarException.class,UpdateCarException.class})
	  public ResponseEntity<String> deleteCarException(DeleteCarException exception) {
	    return ResponseEntity.badRequest().body(exception.getMessage());
	  }
	
}
