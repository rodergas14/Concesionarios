package com.prova.concesionarios.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler {
	
	  @ExceptionHandler(value = {DeleteCarException.class})
	  public ResponseEntity<DeleteCarException> deleteCarException(DeleteCarException exception) {
	    return new ResponseEntity(exception.getMessage(),HttpStatus.BAD_REQUEST);
	  }
	
	  @ExceptionHandler(value = {UpdateCarException.class})
	  public ResponseEntity<UpdateCarException> deleteCarException(UpdateCarException exception) {
			 return new ResponseEntity(exception.getMessage(),HttpStatus.BAD_REQUEST);
	  }
}
