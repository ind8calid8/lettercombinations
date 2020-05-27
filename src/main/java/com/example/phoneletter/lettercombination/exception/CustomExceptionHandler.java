/**
 * 
 */
package com.example.phoneletter.lettercombination.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kannan
 *
 */
@ControllerAdvice
@RestController
public class CustomExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { Exception.class, RuntimeException.class})
	protected String handleException(Exception e) {
		return e.getLocalizedMessage();
	}
}
