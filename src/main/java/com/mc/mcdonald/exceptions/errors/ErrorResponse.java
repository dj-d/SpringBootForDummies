package com.mc.mcdonald.exceptions.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
public class ErrorResponse {
	private HttpStatus status;

	private String errorCode;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;

	private String message;

	private String debugMessage;

	private Object errors;

	private ErrorResponse() {
		timestamp = new Date();
	}

	ErrorResponse(HttpStatus status) {
		this();
		this.status = status;
	}

	ErrorResponse(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.errorCode = "ERR_UNEXPECTED_ERROR";
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ErrorResponse(HttpStatus status, String errorCode, String errorMessage) {
		this();
		this.status = status;
		this.errorCode = errorCode;
		this.message = errorMessage;
	}

	public ErrorResponse(HttpStatus status, String errorCode, String message, Object errors) {
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
		this.errors = errors;
	}

	public ErrorResponse(HttpStatus status, String errorCode, String message, Throwable ex) {
		this();
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}
}
