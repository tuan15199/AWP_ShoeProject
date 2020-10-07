package com.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.exception.DataAlreadyExistException;
import com.project.exception.DataNotFoundException;
import com.project.exception.InvalidNameException;
import com.project.exception.InvalidQuantityException;
import com.project.utils.ErrorResponse;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = DataAlreadyExistException.class)
	public ResponseEntity<Object> exception(DataAlreadyExistException exception) {
		return ErrorResponse.getFormattedError(exception.errorField + " is already exist", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = InvalidNameException.class)
	public ResponseEntity<Object> exception(InvalidNameException exception) {
		return ErrorResponse.getFormattedError(
				exception.errorField + " is invalid, it cannot be a empty string or null", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<Object> exception(DataNotFoundException exception) {
		return ErrorResponse.getFormattedError(exception.errorField + " not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidQuantityException.class)
	public ResponseEntity<Object> exception(InvalidQuantityException exception) {
		return ErrorResponse.getFormattedError(exception.errorField + " cannot be null or less than 0",
				HttpStatus.FORBIDDEN);
	}
}
