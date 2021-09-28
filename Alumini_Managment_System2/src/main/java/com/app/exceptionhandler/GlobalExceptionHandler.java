package com.app.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.customexception.UserHandlingException;
import com.app.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserHandlingException.class)
	public ResponseEntity<?> handleUserHandlingException(UserHandlingException e) {
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleRuntimeException(EmptyResultDataAccessException e) {
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder sb = new StringBuilder("Validation Errors : ");
		ex.getBindingResult().getFieldErrors().forEach(e -> sb.append(e.getDefaultMessage() + " ,"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponse(sb.toString(), LocalDateTime.now()));
	}

}
