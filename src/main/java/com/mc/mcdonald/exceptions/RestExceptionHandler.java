package com.mc.mcdonald.exceptions;

import com.mc.mcdonald.exceptions.customs.ElementAlreadyExistsException;
import com.mc.mcdonald.exceptions.customs.ElementNotFoundException;
import com.mc.mcdonald.exceptions.errors.ErrorResponse;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private ResponseEntity<Object> createResponseEntity(ErrorResponse errorResponse) {
		return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String error = "Malformed JSON request";

		return createResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, "ERR_INVALID_JSON", error, ex));
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String error = "Wrong parameter type";

		return createResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, "ERR_TYPE_MISMATCH", error, ex));
	}

	@ExceptionHandler(ElementAlreadyExistsException.class)
	protected ResponseEntity<Object> handleElementAlreadyExistsException(ElementAlreadyExistsException ex) {
		String errorMessage = "Element already exists for: " + ex.getMessage();

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT, "ERR_ELEMENT_ALREADY_EXISTS", errorMessage);

		return createResponseEntity(errorResponse);
	}

	@ExceptionHandler(ElementNotFoundException.class)
	protected ResponseEntity<Object> handleElementNotFoundException(ElementNotFoundException ex) {
		String errorMessage = "Element not found for: " + ex.getMessage();

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, "ERR_ELEMENT_NOT_FOUND", errorMessage);

		return createResponseEntity(errorResponse);
	}
}
